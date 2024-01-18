package com.example.interviewmanagementsystem.service.candidates;

import com.example.interviewmanagementsystem.entity.candidates.HighestLevel;

import java.util.List;

public interface HighestLevelService {
    List<HighestLevel> findAll();
    HighestLevel findByHighestLevelName(String highestLevelName);
}
