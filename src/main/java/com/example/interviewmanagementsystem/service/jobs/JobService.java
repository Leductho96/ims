package com.example.interviewmanagementsystem.service.jobs;


import com.example.interviewmanagementsystem.entity.jobs.Jobs;
import com.example.interviewmanagementsystem.util.dto.jobs.JobsListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.LevelListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.SkillListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageLevel;
import com.example.interviewmanagementsystem.util.page.PageSkill;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Jobs save(Jobs job);
    void updateJobStatus();

    List<Jobs> findAll();

    Page<JobsListDTO> getPageJob(Integer pageIndex, Integer pageSize, String search, String status);

    PageSkill<SkillListDTO> getPageSkill(Integer id);

    PageLevel<LevelListDTO> getPageLevel(Integer id);

    Optional<Jobs> findByJobId(Integer id);

    void deleteJob(Integer jobId);

    void saveAllJob(List<Jobs> list);

    Jobs changeStatus(Integer id);

    Jobs findByTitle(String title);

    List<Jobs> getJobsHaveStatusOpen();
}
