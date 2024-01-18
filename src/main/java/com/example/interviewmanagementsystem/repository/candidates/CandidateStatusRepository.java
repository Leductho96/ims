package com.example.interviewmanagementsystem.repository.candidates;

import com.example.interviewmanagementsystem.entity.candidates.CandidateStatus;
import org.springframework.data.repository.CrudRepository;

public interface CandidateStatusRepository extends CrudRepository<CandidateStatus,Integer> {

    CandidateStatus findByStatusName(String statusName);
}
