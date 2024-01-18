package com.example.interviewmanagementsystem.util.dto.user;

import com.example.interviewmanagementsystem.entity.candidates.Positions;
import com.example.interviewmanagementsystem.entity.user.Department;
import com.example.interviewmanagementsystem.enums.Gender;
import com.example.interviewmanagementsystem.enums.user.UserStatus;
import com.example.interviewmanagementsystem.util.validation.candidate.MinAge;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddUserDTO {

    @NotBlank(message = "{ME042}")
    private String fullName;

    @NotBlank(message = "{ME044}")
    @Email(message = "{ME009}")
    private String email;

    @MinAge(value = 18, message = "Date Of Birth must be >= {value}")
    @Past(message = "{ME010}")
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

    @NotNull(message = "{ME002}")
    private Positions position;

    @NotEmpty(message = "{ME060}")
    private Set<String> rolesSet = new HashSet<>();
}
