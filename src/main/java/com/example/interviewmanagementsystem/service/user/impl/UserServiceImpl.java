package com.example.interviewmanagementsystem.service.user.impl;

import com.example.interviewmanagementsystem.config.security.SecurityUtils;
import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.repository.user.UserRepository;
import com.example.interviewmanagementsystem.service.user.UserService;
import com.example.interviewmanagementsystem.util.dto.user.UserListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserListDTO> getPageUser(Integer pageIndex, Integer pageSize, String search, String field) {
        Integer totalPage;
        List<UserListDTO> users = userRepository.getUserPaging(pageIndex, pageSize, search, field);

        if (pageSize >= userRepository.getAllUser(search, field).size()) {
            totalPage = 1;
        } else {
            totalPage = (int) Math.ceil(userRepository.getAllUser(search,field).size() * 1.0 / pageSize);
        }

        String role = SecurityUtils.getCurrentRole().toString();

        Page<UserListDTO> page = new Page<>(totalPage, pageIndex, users, pageSize, role);
        return page;
    }

    @Override
    public Optional<User> findByUserId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {
        User findUser = userRepository.findByEmailIgnoreCase(email);

        if(findUser != null) {
            findUser.setResetPasswordToken(token);
            findUser.setExpriedDate(LocalDateTime.now().plusHours(24));
            findUser.setClickResetAttempt(0);
            userRepository.save(findUser);
        } else {
            throw new UsernameNotFoundException("Could not find any customer with the email" + email);
        }
    }

    @Override
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        System.out.println(newPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existByUserName(String username) {
        return userRepository.existsByUsernameIgnoreCase(username);
    }

    @Override
    public boolean existByPhoneNumber(String phoneNumber) {
        return userRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public boolean existById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public String findFullNameByUserName(String userName) {
        return userRepository.findFullNameByUserName(userName);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getUsersIsManager() {
        return userRepository.getUsersIsManager();
    }

    @Override
    public boolean existByIdAndPhoneNumber(Integer id, String phoneNumber) {
        return userRepository.existsByIdAndPhoneNumber(id, phoneNumber);
    }


    @Override
    public boolean existByIdAndEmail(Integer id, String email) {
        return userRepository.existsByIdAndEmail(id, email);
    }


}
