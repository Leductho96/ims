package com.example.interviewmanagementsystem.service.candidates;

import com.example.interviewmanagementsystem.entity.candidates.CandidateStatus;

import java.util.List;

public interface CandidateStatusService {
    List<CandidateStatus> findAll();

    CandidateStatus findByStatusName(String statusName);

    CandidateStatus findByCandidateStatusName(String candidateStatusName);
}
