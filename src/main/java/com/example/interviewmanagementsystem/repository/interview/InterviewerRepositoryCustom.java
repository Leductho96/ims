package com.example.interviewmanagementsystem.repository.interview;

import com.example.interviewmanagementsystem.entity.interview.Interviewer;

public interface InterviewerRepositoryCustom {
    Interviewer findByInterviewerName(String interviewerName);

}
