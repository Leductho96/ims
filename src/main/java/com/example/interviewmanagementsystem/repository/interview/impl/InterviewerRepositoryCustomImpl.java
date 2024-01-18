package com.example.interviewmanagementsystem.repository.interview.impl;

import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.repository.interview.InterviewerRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class InterviewerRepositoryCustomImpl implements InterviewerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Interviewer findByInterviewerName(String interviewerName) {
        return (Interviewer) entityManager.createQuery("select i from Interviewer i where i.interviewerName = :name")
                .setParameter("name", interviewerName)
                .getSingleResult();
    }
}
