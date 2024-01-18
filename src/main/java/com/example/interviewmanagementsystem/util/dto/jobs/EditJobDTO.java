package com.example.interviewmanagementsystem.util.dto.jobs;

import com.example.interviewmanagementsystem.enums.job.JobStatus;
import com.example.interviewmanagementsystem.util.validation.editJob.CheckEndDate;
import com.example.interviewmanagementsystem.util.validation.editJob.CheckMaxSalary;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@CheckEndDate({"startDate","endDate"})
@CheckMaxSalary({"minSalary","maxSalary"})
public class EditJobDTO {

    private Integer id;

    @NotBlank(message = "{ME034}")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "{ME017}")
    @NotNull(message = "{ME035}" )
    private LocalDate startDate;

    @Min(value = 0, message = "{ME028}")
    private BigDecimal minSalary;

    @NotNull(message = "{ME036}")
    @Min(value = 0, message = "{ME028}")
    private BigDecimal maxSalary;

    @NotBlank(message = "{ME037}")
    private String workingAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{ME038}")
    private LocalDate endDate;

    private String description;

    @NotEmpty(message = "{ME039}")
    private Set<String> skillsSet = new HashSet<>();

    @NotEmpty(message = "{ME040}")
    private Set<String> benefitSet = new HashSet<>();

    @NotEmpty(message = "{ME041}")
    private Set<String> levelsSet = new HashSet<>();

    private JobStatus status;
}
