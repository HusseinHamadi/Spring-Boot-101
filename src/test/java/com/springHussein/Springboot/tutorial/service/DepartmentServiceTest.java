package com.springHussein.Springboot.tutorial.service;

import com.springHussein.Springboot.tutorial.entity.Department;
import com.springHussein.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    DepartmentService service;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Beirut")
                        .departmentId(1L)
                        .departmentCode("IT-04")
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data Based On Department Name")
    public void testOf_fetchingDepartment_byPassingName(){
        String departmentName="IT";
        Department found = service.fetchDepartmentByName(departmentName);
        assertEquals(found.getDepartmentName(),departmentName);
    }
}