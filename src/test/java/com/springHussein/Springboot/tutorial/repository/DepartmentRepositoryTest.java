package com.springHussein.Springboot.tutorial.repository;

import com.springHussein.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class DepartmentRepositoryTest {
    private long Id;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Beirut")
                        .departmentCode("IT-04")
                        .build();
        entityManager.persist(department);
        Id=department.getDepartmentId();
    }
    @Test
    public void whenFindById_ReturnDepartment(){

        Department department=departmentRepository.findById(Id).get();
        System.out.println(Id);
        Assertions.assertEquals(department.getDepartmentName(),"IT");
    }
}