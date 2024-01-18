package com.example.interviewmanagementsystem.service.candidates.impl;

import com.example.interviewmanagementsystem.entity.candidates.Positions;
import com.example.interviewmanagementsystem.repository.candidates.PositionRepository;
import com.example.interviewmanagementsystem.service.candidates.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    @Override
    public List<Positions>  findAll() {
       return (List<Positions>) positionRepository.findAll();
    }

    @Override
    public Positions findByPositionName(String positionName) {
        return positionRepository.findByPositionName(positionName);
    }
}
