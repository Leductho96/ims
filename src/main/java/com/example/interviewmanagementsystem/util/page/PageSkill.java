package com.example.interviewmanagementsystem.util.page;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@RequiredArgsConstructor
@Data
public class PageSkill<T> implements Serializable {

    private final Collection<T> skills;
}
