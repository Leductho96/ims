package com.example.interviewmanagementsystem.util.dto.interview;


import com.example.interviewmanagementsystem.enums.interview.InterviewResult;
import com.example.interviewmanagementsystem.enums.interview.ScheduleStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class InterviewListDTO {

    private Integer id;

    private String scheduleTitle;

    private LocalDate interviewDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private InterviewResult result;

    private ScheduleStatus status;

}

