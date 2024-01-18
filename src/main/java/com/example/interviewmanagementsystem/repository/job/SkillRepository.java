package com.example.interviewmanagementsystem.repository.job;

import com.example.interviewmanagementsystem.entity.jobs.Skills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skills,Integer> {

    Skills findBySkillName(String skillName);
}
