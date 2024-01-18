package com.example.interviewmanagementsystem.repository.user;

import com.example.interviewmanagementsystem.entity.user.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer>, UserRepositoryCustom {

    Roles findByRoleName(String roleName);
}
