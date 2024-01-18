package com.example.interviewmanagementsystem.service.jobs.Impl;

import com.example.interviewmanagementsystem.entity.jobs.Skills;
import com.example.interviewmanagementsystem.repository.job.SkillRepository;
import com.example.interviewmanagementsystem.service.jobs.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    @Override
    public List<Skills> findAll() {
        return (List<Skills>) skillRepository.findAll();
    }

    @Override
    public Skills findBySkillName(String skillName) {
        return skillRepository.findBySkillName(skillName);
    }
}
