package com.example.interviewmanagementsystem.repository.user;

import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.util.dto.user.UserListDTO;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserListDTO> getAllUser(String search, String field);

    List<UserListDTO> getUserPaging(Integer pageIndex, Integer pageSize, String search, String role);

    List<User> getUsersIsManager();
}
