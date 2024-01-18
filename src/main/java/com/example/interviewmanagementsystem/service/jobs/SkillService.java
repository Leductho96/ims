package com.example.interviewmanagementsystem.service.jobs;

import com.example.interviewmanagementsystem.entity.jobs.Skills;

import java.util.List;

public interface SkillService {

    List<Skills> findAll();
    Skills findBySkillName(String skillName);
}
