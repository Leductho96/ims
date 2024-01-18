package com.example.interviewmanagementsystem.api.user;

import com.example.interviewmanagementsystem.service.user.UserService;
import com.example.interviewmanagementsystem.util.dto.user.UserListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class ApiUserController {

    private final UserService userService;

    @GetMapping
    public Page<UserListDTO> getUsers(
            @RequestParam(defaultValue = "1", required = false, value = "pageIndex") Integer pageIndex,
            @RequestParam(defaultValue = "7", required = false, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "search") String search,
            @RequestParam(required = false, value = "role") String role
    ) {
        return userService.getPageUser(pageIndex, pageSize, search, role);
    }
}
