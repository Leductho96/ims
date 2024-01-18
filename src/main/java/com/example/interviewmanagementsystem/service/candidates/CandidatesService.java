package com.example.interviewmanagementsystem.service.candidates;

import com.example.interviewmanagementsystem.entity.candidates.CandidateStatus;
import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidatePositionDTO;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidateRecruiterDTO;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidatesListDTO;
import com.example.interviewmanagementsystem.util.page.Page;

import java.util.List;
import java.util.Optional;

public interface CandidatesService {

    Page<CandidatesListDTO> getPageCandidates(Integer pageIndex, Integer pageSize, String search, String field);

    CandidatePositionDTO getPagePosition(Integer id);

    CandidateRecruiterDTO getPageRecruiter(Integer id);

    Optional<Candidates> findByCandidateId(Integer id);

    Candidates save(Candidates candidates);

    void deleteCandidate(Integer id);

    Boolean existsByPhone(String phoneNumber);

    Boolean existsByEmail(String email);

    Boolean existsByPhoneAndId(String phoneNumber, Integer id);

    Boolean existsByEmailAndId(String email, Integer id);

    List<Candidates> findAll();

    Candidates findByFullName(String fullName);

    List<Candidates> getCandidatesHaveStatusOtherThanBan();

    void updateStatusCancelScheduleInterview(Integer id, CandidateStatus status);

    boolean existsByPhoneOrEmail(String phone, String email);

    Candidates findCandidatesByOfferId(Integer id);

    List<Candidates> getCandidatesHaveStatusPassedInterview();
}
