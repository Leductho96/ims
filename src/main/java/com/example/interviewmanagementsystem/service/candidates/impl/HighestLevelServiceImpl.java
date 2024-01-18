package com.example.interviewmanagementsystem.service.candidates.impl;

import com.example.interviewmanagementsystem.entity.candidates.HighestLevel;
import com.example.interviewmanagementsystem.repository.candidates.HighestLevelRepository;
import com.example.interviewmanagementsystem.service.candidates.HighestLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HighestLevelServiceImpl implements HighestLevelService {
    private final HighestLevelRepository highestLevelRepository;
    @Override
    public List<HighestLevel> findAll() {
        return (List<HighestLevel>) highestLevelRepository.findAll();
    }

    @Override
    public HighestLevel findByHighestLevelName(String highestLevelName) {
        return highestLevelRepository.findByHighestLevelName(highestLevelName);
    }
}
