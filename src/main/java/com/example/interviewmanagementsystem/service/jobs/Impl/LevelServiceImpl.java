package com.example.interviewmanagementsystem.service.jobs.Impl;


import com.example.interviewmanagementsystem.entity.jobs.Levels;
import com.example.interviewmanagementsystem.repository.job.LevelRepository;
import com.example.interviewmanagementsystem.service.jobs.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    @Override
    public List<Levels> findAll() {
        return (List<Levels>) levelRepository.findAll();
    }

    @Override
    public Levels findByLevelName(String levelName) {
        return levelRepository.findByLevelName(levelName);
    }
}
