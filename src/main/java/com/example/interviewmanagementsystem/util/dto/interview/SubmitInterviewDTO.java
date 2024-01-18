package com.example.interviewmanagementsystem.util.dto.interview;

import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.candidates.Recruiters;
import com.example.interviewmanagementsystem.entity.jobs.Jobs;
import com.example.interviewmanagementsystem.enums.interview.InterviewResult;
import com.example.interviewmanagementsystem.enums.interview.ScheduleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubmitInterviewDTO {

    private Integer id;

    private String scheduleTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate interviewDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

    private String notes;

    private String Location;

    private String meetingId;

    private InterviewResult result;

    private ScheduleStatus status;


    private Candidates candidates;


    private Jobs jobs;


    private Recruiters recruiters;


    private Set<String> interviewers = new HashSet<>();
}
