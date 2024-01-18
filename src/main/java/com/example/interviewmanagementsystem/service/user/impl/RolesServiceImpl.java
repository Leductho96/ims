package com.example.interviewmanagementsystem.service.user.impl;

import com.example.interviewmanagementsystem.entity.user.Roles;
import com.example.interviewmanagementsystem.repository.user.RolesRepository;
import com.example.interviewmanagementsystem.service.user.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Override
    public Roles findByRoleName(String roleName) {
        return rolesRepository.findByRoleName(roleName);
    }

    @Override
    public Roles findByRoleId(Integer id) {
        return rolesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Roles> findAllRoles() {
        return rolesRepository.findAll();
    }
}
