package com.example.interviewmanagementsystem.repository.candidates;

import com.example.interviewmanagementsystem.entity.candidates.HighestLevel;
import org.springframework.data.repository.CrudRepository;

public interface HighestLevelRepository extends CrudRepository<HighestLevel,Integer> {
    HighestLevel findByHighestLevelName(String highestLevelName);
}
