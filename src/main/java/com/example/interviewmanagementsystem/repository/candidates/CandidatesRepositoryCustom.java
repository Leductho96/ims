package com.example.interviewmanagementsystem.repository.candidates;


import com.example.interviewmanagementsystem.entity.candidates.CandidateStatus;
import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidatePositionDTO;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidateRecruiterDTO;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidatesListDTO;

import java.util.List;

public interface CandidatesRepositoryCustom  {
    public List<CandidatesListDTO> getCandidatesPaging(Integer pageIndex, Integer pageSize, String search, String status);
    List<CandidatesListDTO> getCandidatesSearch(String search, String status);
    CandidatePositionDTO getPositionById(Integer id);
    CandidateRecruiterDTO getRecruiterById(Integer id);
    List<Candidates> getCandidatesHaveStatusOtherThanBan();
    void updateStatusCancelScheduleInterview(Integer id, CandidateStatus status);
    List<Candidates> getCandidatesHaveStatusPassedInterview();
}
