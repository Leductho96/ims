package com.example.interviewmanagementsystem.util.dto.user;

import com.example.interviewmanagementsystem.entity.user.Department;
import com.example.interviewmanagementsystem.entity.user.Roles;
import com.example.interviewmanagementsystem.enums.Gender;
import com.example.interviewmanagementsystem.enums.user.UserStatus;
import com.example.interviewmanagementsystem.util.validation.candidate.MinAge;
import com.example.interviewmanagementsystem.util.validation.checkUserPassword.FieldMatch;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@FieldMatch({"password", "confirmPassword"})
public class UserDTO {

    @NotBlank(message = "{ME042}")
    private String username;

    @NotBlank(message = "{ME069}")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{7,}$\n", message = "{ME007}")
    private String password;

    @NotBlank(message = "{ME006}")
    private String confirmPassword;

    @NotBlank(message = "{ME042}")
    private String fullName;

    @NotBlank(message = "{ME045}")
    @Email(message = "{ME045}")
    private String email;

    @MinAge(value = 18, message = "Date Of Birth must be >= {value}")
    @Past(message = "{ME070}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String address;

    @Pattern(regexp = "^0[0-9]{6,12}$", message = "Phone Number must start with 0 and have 7 to 12 digits")
    private String phoneNumber;

    @NotNull(message = "{ME047}")
    private Gender gender;

    @NotNull(message = "{ME061}")
    private UserStatus status;

    private String note;

    @NotNull(message = "{ME059}")
    private Department department;

    @NotNull(message = "{ME060}")
    private Set<Roles> rolesSet;
}
