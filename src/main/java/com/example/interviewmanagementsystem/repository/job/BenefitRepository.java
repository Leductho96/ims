package com.example.interviewmanagementsystem.repository.job;

import com.example.interviewmanagementsystem.entity.jobs.Benefit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends CrudRepository<Benefit,Integer> {

    Benefit findByBenefitName(String benefitName);
}
