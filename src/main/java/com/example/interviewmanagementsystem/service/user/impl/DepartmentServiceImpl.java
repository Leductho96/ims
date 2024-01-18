package com.example.interviewmanagementsystem.service.user.impl;

import com.example.interviewmanagementsystem.entity.user.Department;
import com.example.interviewmanagementsystem.repository.user.DepartmentRepository;
import com.example.interviewmanagementsystem.service.user.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }
}
