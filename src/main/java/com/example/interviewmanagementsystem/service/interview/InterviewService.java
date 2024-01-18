package com.example.interviewmanagementsystem.service.interview;

import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.enums.interview.InterviewResult;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewCandidateDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewJobDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewListDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewerListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageInterviewer;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InterviewService {

    Optional<Interview> findById(Integer id);

    void save(Interview interview);

    void updateStatus(Integer id);

    List<Interview> findByInterviewDate(LocalDate interviewDate);

    void sendEmail(String recipientEmail, Interview interview, String link) throws MessagingException, UnsupportedEncodingException;

    Candidates getCandidateByInterviewId(Integer id);

    List<Interview> getInterviewsPass();

    Page<InterviewListDTO> getPageInterview(Integer pageIndex, Integer pageSize, String search, String interviewer, String status);

    InterviewCandidateDTO getPageCandidate(Integer id);

    PageInterviewer<InterviewerListDTO> getPageInterviewer(Integer id);

    InterviewJobDTO getPageJob(Integer id);

    List<Interview> findInterviewByCandidatesAndResult(Integer id, InterviewResult result);

    List<Interview> getListInterviewByCandidateId(Integer id);

    List<Interviewer> findListInterviewerByInterviewId(Integer id);

    List<Interview> findAll();
}
