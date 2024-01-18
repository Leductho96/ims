package com.example.interviewmanagementsystem.util.dto.offer;

import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.candidates.Positions;
import com.example.interviewmanagementsystem.entity.candidates.Recruiters;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.jobs.Levels;
import com.example.interviewmanagementsystem.entity.user.Department;
import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.enums.offer.ContractType;
import com.example.interviewmanagementsystem.util.validation.offer.CheckDateFromTo;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CheckDateFromTo({"contractPeriodFrom", "contractPeriodTo"})
public class AddOfferDTO {

    private Integer id;

    @NotNull(message = "{ME042}")
    private Candidates candidate;

    @NotNull(message = "{ME048}")
    private Positions position;

    @NotNull(message = "{ME062}")
    private User approvedBy;

    @NotNull(message = "{ME063}")
    private Interview interviewInfo;

    @NotNull(message = "{ME064}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractPeriodFrom;

    @NotNull(message = "{ME065}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractPeriodTo;

    private String interviewNotes;

    @NotNull(message = "{ME066}")
    private ContractType contractType;

    @NotNull(message = "{ME041}")
    private Levels level;

    @NotNull(message = "{ME059}")
    private Department department;

    @NotNull(message = "{ME050}")
    private Recruiters recruiterOwner;

    @NotNull(message = "{ME067}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Due date must be later than current date")
    private LocalDate dueDate;

    @NotNull(message = "{ME068}")
    private BigDecimal basicSalary;

    private String note;
}
