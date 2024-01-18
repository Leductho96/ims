package com.example.interviewmanagementsystem.util.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OfferCandidateListDTO {
   private String name;
   private String email;

}
