package com.example.interviewmanagementsystem.service.jobs;


import com.example.interviewmanagementsystem.entity.jobs.Benefit;

import java.util.List;

public interface BenefitService {

    List<Benefit> findAll();

    Benefit findByBenefitName(String benefitName);


}
