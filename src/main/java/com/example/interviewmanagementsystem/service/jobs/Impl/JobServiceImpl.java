package com.example.interviewmanagementsystem.service.jobs.Impl;

import com.example.interviewmanagementsystem.config.security.SecurityUtils;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.jobs.Jobs;
import com.example.interviewmanagementsystem.enums.job.JobStatus;
import com.example.interviewmanagementsystem.repository.interview.InterviewRepository;
import com.example.interviewmanagementsystem.repository.job.JobsRepository;
import com.example.interviewmanagementsystem.service.jobs.JobService;
import com.example.interviewmanagementsystem.util.dto.jobs.JobsListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.LevelListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.SkillListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageLevel;
import com.example.interviewmanagementsystem.util.page.PageSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobsRepository jobsRepository;
    private final InterviewRepository interviewRepository;
    @Override
    @Transactional
    public Jobs save(Jobs job) {

        return jobsRepository.save(job);
    }

    @Override
    @Transactional
    public void updateJobStatus() {

        LocalDate currentDate = LocalDate.now();
        LocalDateTime checkTime = LocalDate.now().atStartOfDay().plusDays(1);
        List<Jobs> jobToOpen = jobsRepository.findByStartDateAndStatus(currentDate, JobStatus.DRAFT);
        List<Jobs> jobToClose = jobsRepository.findByEndDateAndStatus(LocalDate.from(checkTime), JobStatus.OPEN);

        for (Jobs job: jobToOpen){
            job.setStatus(JobStatus.OPEN);
            jobsRepository.save(job);
        }
        for (Jobs job: jobToClose){
            job.setStatus(JobStatus.CLOSED);
            jobsRepository.save(job);
        }
    }

    @Override
    public List<Jobs> findAll() {

        return (List<Jobs>) jobsRepository.findAll();
    }

    public Page<JobsListDTO> getPageJob(Integer pageIndex, Integer pageSize, String search, String status){
        Integer totalPage;
        List<JobsListDTO> jobs = jobsRepository.getJobPaging(pageIndex, pageSize, search, status);

        if (pageSize >= jobsRepository.getAllJob(search, status).size()) {
            totalPage = 1;
        } else {
            totalPage = (int) Math.ceil(jobsRepository.getAllJob(search, status).size()*1.0 / pageSize);
        }

        String role = SecurityUtils.getCurrentRole().toString();

        Page<JobsListDTO> page = new Page<>(totalPage, pageIndex, jobs, pageSize, role);
        return page;
    }

    public PageSkill<SkillListDTO> getPageSkill(Integer id) {
        List<SkillListDTO> skillListDTOList = jobsRepository.getSkillsById(id);
        PageSkill<SkillListDTO> pageSkill = new PageSkill<>(skillListDTOList);
        return pageSkill;
    }

    public PageLevel<LevelListDTO> getPageLevel(Integer id) {
        List<LevelListDTO> levelListDTOList = jobsRepository.getLevelsById(id);
        PageLevel<LevelListDTO> pageLevel = new PageLevel<>(levelListDTOList);
        return pageLevel;
    }

    @Override
    public Optional<Jobs> findByJobId(Integer id) {
        return jobsRepository.findById(id);
    }

    @Override
    public void deleteJob(Integer jobId) {
            Jobs job = jobsRepository.findById(jobId).orElse(null);
            List<Interview> interviewList = interviewRepository.findByJobId(jobId);
            for (Interview it: interviewList){
                it.setDeleted(true);
                interviewRepository.save(it);
            }

            if (job != null) {
                job.setEndDate(LocalDate.now());
                job.setDeleted(true);

                jobsRepository.save(job);
            }
        }

    @Override
    public void saveAllJob(List<Jobs> list) {
        jobsRepository.saveAll(list);
    }

    @Override
    public Jobs changeStatus(Integer id) {
        Jobs editJob = jobsRepository.findById(id).orElse(null);

        assert editJob!=null;
        LocalDate startDate = editJob.getStartDate();
        LocalDate endDate = editJob.getEndDate();
        LocalDate currentDate = LocalDate.now();

        if(startDate.isBefore(currentDate)||startDate.equals(currentDate)){
            editJob.setStatus(JobStatus.OPEN);
        }else if(startDate.isAfter(currentDate)){
            editJob.setStatus(JobStatus.DRAFT);
        }else if(endDate.equals(currentDate)){
            editJob.setStatus(JobStatus.CLOSED);
        }

        return jobsRepository.save(editJob);
    }

    @Override
    public List<Jobs> getJobsHaveStatusOpen() {
        return jobsRepository.getJobsHaveStatusOpen();
    }

    @Override
    public Jobs findByTitle(String title) {
        return jobsRepository.findByTitle(title);
    }


}

