package com.example.interviewmanagementsystem.repository.user;

import com.example.interviewmanagementsystem.entity.user.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDepartmentName(String departmentName);
}
