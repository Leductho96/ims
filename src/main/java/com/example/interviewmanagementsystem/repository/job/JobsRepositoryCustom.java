package com.example.interviewmanagementsystem.repository.job;

import com.example.interviewmanagementsystem.entity.jobs.Jobs;
import com.example.interviewmanagementsystem.util.dto.jobs.JobsListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.LevelListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.SkillListDTO;

import java.util.List;

public interface JobsRepositoryCustom {

    List<JobsListDTO> getAllJob(String search, String status);

    List<JobsListDTO> getJobPaging(Integer pageIndex, Integer pageSize, String search, String status);

    List<SkillListDTO> getSkillsById(Integer id);

    List<LevelListDTO> getLevelsById(Integer id);

    List<Jobs> getJobsHaveStatusOpen();
}
