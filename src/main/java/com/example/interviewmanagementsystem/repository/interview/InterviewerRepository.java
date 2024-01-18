package com.example.interviewmanagementsystem.repository.interview;

import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepository extends CrudRepository<Interviewer,Integer> {
    Interviewer findByInterviewerName(String interviewerName);


}
