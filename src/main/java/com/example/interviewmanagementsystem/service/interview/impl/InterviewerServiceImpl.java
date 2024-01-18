package com.example.interviewmanagementsystem.service.interview.impl;

import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.repository.interview.InterviewerRepository;
import com.example.interviewmanagementsystem.service.interview.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterviewerServiceImpl implements InterviewerService {

    private final InterviewerRepository interviewerRepository;
    @Override
    public List<Interviewer> findAll() {
        return (List<Interviewer>) interviewerRepository.findAll();
    }

    @Override
    public Interviewer findByInterviewerName(String interviewerName) {
        return interviewerRepository.findByInterviewerName(interviewerName);
    }

    @Override
    public Interviewer save(Interviewer interviewer) {
        return interviewerRepository.save(interviewer);
    }

    @Override
    public Optional<Interviewer> findById(Integer id) {
        return interviewerRepository.findById(id);
    }


}
