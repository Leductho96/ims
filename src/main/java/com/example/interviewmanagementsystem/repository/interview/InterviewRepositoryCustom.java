package com.example.interviewmanagementsystem.repository.interview;


import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewCandidateDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewJobDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewListDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewerListDTO;

import java.util.List;

public interface InterviewRepositoryCustom {

    void updateStatus(Integer id);

    Candidates getCandidateByInterviewId(Integer id);

    List<Interview> getInterviewsPass();

    List<InterviewListDTO> getAllInterview(String search, String interviewer, String status);

    List<InterviewListDTO> getInterviewPaging(Integer pageIndex, Integer pageSize, String search, String interviewer, String status);

    List<InterviewerListDTO> getInterviewerById(Integer id);

    InterviewCandidateDTO getCandidateById(Integer id);

    InterviewJobDTO getJobById(Integer id);

    List<Interview> getListInterviewByCandidateId(Integer id);

    List<Interviewer> findListInterviewerByInterviewId(Integer id);

}
