package com.example.interviewmanagementsystem.repository.job;

import com.example.interviewmanagementsystem.entity.jobs.Levels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LevelRepository extends CrudRepository<Levels,Integer> {

    Levels findByLevelName(String levelName);
}
