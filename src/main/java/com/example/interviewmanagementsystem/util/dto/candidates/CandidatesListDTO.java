package com.example.interviewmanagementsystem.util.dto.candidates;

import com.example.interviewmanagementsystem.entity.candidates.CandidateStatus;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CandidatesListDTO {

    private Integer id;

    private String fullName;

    private String phone;

    private String email;

    private CandidateStatus candidateStatus;

}
