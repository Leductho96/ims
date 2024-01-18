package com.example.interviewmanagementsystem.entity.jobs;

import com.example.interviewmanagementsystem.entity.BaseEntity;
import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Skills extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(mappedBy = "skillsSet")
    private Set<Jobs> jobsSet=new HashSet<>();

    @ManyToMany(mappedBy = "skillsSet")
    private Set<Candidates> candidatesSet = new HashSet<>();
}
