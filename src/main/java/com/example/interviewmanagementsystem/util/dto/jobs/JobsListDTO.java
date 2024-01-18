package com.example.interviewmanagementsystem.util.dto.jobs;

import com.example.interviewmanagementsystem.enums.job.JobStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class JobsListDTO {

    private Integer id;

    private String title;

    private LocalDate startDate;

    private JobStatus status;

    private LocalDate endDate;
}
