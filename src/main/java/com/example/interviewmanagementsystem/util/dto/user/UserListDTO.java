package com.example.interviewmanagementsystem.util.dto.user;

import com.example.interviewmanagementsystem.entity.candidates.Positions;
import com.example.interviewmanagementsystem.entity.user.Roles;
import com.example.interviewmanagementsystem.enums.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserListDTO {

    private Integer id;

    private String username;

    private String email;

    private String phoneNumber;

    private Positions position;

    private Roles role;

    private UserStatus status;
}
