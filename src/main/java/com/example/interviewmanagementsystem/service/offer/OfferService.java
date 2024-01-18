package com.example.interviewmanagementsystem.service.offer;

import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.offer.Offer;
import com.example.interviewmanagementsystem.util.dto.offer.DepartmentListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferCandidateListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferUserListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageDepartment;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OfferService {

    void save(Offer offer);

    List<Offer> findByDueDate(LocalDate dueDate);

    Optional<Offer> findById(Integer id);

    void sendEmail(String recipientEmail, Offer offer, String link) throws MessagingException, UnsupportedEncodingException;



    List<Offer> findAll();
    List<Offer> findAllByDate(LocalDate startDate, LocalDate endDate);

    Page<OfferListDTO> getPageOffer(Integer pageIndex, Integer pageSize, String search, String department, String status);

//    PageCandidate<OfferCandidateListDTO>getPageCandidate(Integer id);

    PageDepartment<DepartmentListDTO> getPageDepartment(Integer id);

    OfferUserListDTO getPageUser(Integer id);

    OfferCandidateListDTO getPageCandidate(Integer id);

    Offer findByOfferToken(String token);

    void sendEmailToCandidate(Candidates candidate, String offerLink) throws MessagingException, UnsupportedEncodingException;
}
