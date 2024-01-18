package com.example.interviewmanagementsystem.service.user;

import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.util.dto.user.UserListDTO;
import com.example.interviewmanagementsystem.util.page.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<UserListDTO> getPageUser(Integer pageIndex, Integer pageSize, String search, String field);

    Optional<User> findByUserId(Integer id);

    void updateResetPasswordToken(String token, String email);

    User getByResetPasswordToken(String token);

    void updatePassword(User user, String newPassword);

    void save(User user);

    void deleteUser(Integer id);

    boolean existByUserName(String username);

    boolean existByPhoneNumber(String phoneNumber);

    boolean existByEmail(String email);

    boolean existById(Integer id);

    String findFullNameByUserName(String userName);

    User findByUserName(String userName);

    List<User> getUsersIsManager();

    boolean existByIdAndEmail(Integer id, String email);

    boolean existByIdAndPhoneNumber(Integer id, String phoneNumber);

}
