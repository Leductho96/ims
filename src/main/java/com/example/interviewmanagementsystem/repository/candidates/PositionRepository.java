package com.example.interviewmanagementsystem.repository.candidates;

import com.example.interviewmanagementsystem.entity.candidates.Positions;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Positions,Integer> {
    Positions findByPositionName(String positionName);
}
