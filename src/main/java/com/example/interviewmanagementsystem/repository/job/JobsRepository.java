package com.example.interviewmanagementsystem.repository.job;

import com.example.interviewmanagementsystem.entity.jobs.Jobs;
import com.example.interviewmanagementsystem.enums.job.JobStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobsRepository extends CrudRepository<Jobs,Integer>, JobsRepositoryCustom {

    List<Jobs> findByStartDateAndStatus(LocalDate startDate, JobStatus status);

    List<Jobs> findByEndDateAndStatus(LocalDate endDate, JobStatus status);

    Jobs findByTitle(String titleName);



}
