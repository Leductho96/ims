package com.example.interviewmanagementsystem.service.user;

import com.example.interviewmanagementsystem.entity.user.Department;

import java.util.List;

public interface DepartmentService {

    Department findByDepartmentName (String departmentName);

    List<Department> findAllDepartment();
}
