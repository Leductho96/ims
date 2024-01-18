package com.example.interviewmanagementsystem.repository.offer;

import com.example.interviewmanagementsystem.util.dto.offer.DepartmentListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferCandidateListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferUserListDTO;

import java.util.List;

public interface OfferRepositoryCustom {

    List<OfferListDTO> getAllOffer(String search,String department,String status);
    List<OfferListDTO> getOfferPage(Integer pageIndex, Integer pageSize, String search, String department, String status);

    OfferCandidateListDTO getCandidateById(Integer id);

    List<DepartmentListDTO>getDepartmentById(Integer id);

   OfferUserListDTO getUserById(Integer id);
}
