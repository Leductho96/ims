package com.example.interviewmanagementsystem.service.jobs.Impl;

import com.example.interviewmanagementsystem.entity.jobs.Benefit;
import com.example.interviewmanagementsystem.repository.job.BenefitRepository;
import com.example.interviewmanagementsystem.service.jobs.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;
    @Override
    public List<Benefit> findAll() {
        return (List<Benefit>) benefitRepository.findAll();
    }

    @Override
    public Benefit findByBenefitName(String benefitName) {
        return benefitRepository.findByBenefitName(benefitName);
    }
}
