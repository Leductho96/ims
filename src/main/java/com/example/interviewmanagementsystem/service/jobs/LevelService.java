package com.example.interviewmanagementsystem.service.jobs;

import com.example.interviewmanagementsystem.entity.jobs.Levels;

import java.util.List;

public interface LevelService {

  List<Levels> findAll();

  Levels findByLevelName(String levelName);
}
