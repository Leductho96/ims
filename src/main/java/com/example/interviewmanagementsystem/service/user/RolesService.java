package com.example.interviewmanagementsystem.service.user;

import com.example.interviewmanagementsystem.entity.user.Roles;

import java.util.List;

public interface RolesService {

    Roles findByRoleName (String roleName);
    Roles findByRoleId (Integer id);
    List<Roles> findAllRoles();
}
