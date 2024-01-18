package com.example.interviewmanagementsystem.service.candidates.impl;

import com.example.interviewmanagementsystem.entity.candidates.CandidateStatus;
import com.example.interviewmanagementsystem.repository.candidates.CandidateStatusRepository;
import com.example.interviewmanagementsystem.service.candidates.CandidateStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateStatusServiceImpl implements CandidateStatusService {
    private final CandidateStatusRepository candidateStatusRepository;
    @Override
    public List<CandidateStatus> findAll() {
        return (List<CandidateStatus>) candidateStatusRepository.findAll();
    }

    @Override
    public CandidateStatus findByStatusName(String statusName) {
        return candidateStatusRepository.findByStatusName(statusName);
    }

    @Override
    public CandidateStatus findByCandidateStatusName(String candidateStatusName) {
        return candidateStatusRepository.findByStatusName(candidateStatusName);
    }


}
