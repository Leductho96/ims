package com.example.interviewmanagementsystem.service.candidates;

import com.example.interviewmanagementsystem.entity.candidates.Positions;

import java.util.List;

public interface PositionService {
    List<Positions> findAll();
    Positions findByPositionName(String positionName);
}
