package com.springHussein.Springboot.tutorial.service;

import com.springHussein.Springboot.tutorial.Error.DepartmentNotFoundException;
import com.springHussein.Springboot.tutorial.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {


    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
