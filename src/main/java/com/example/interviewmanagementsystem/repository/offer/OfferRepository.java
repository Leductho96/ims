package com.example.interviewmanagementsystem.repository.offer;

import com.example.interviewmanagementsystem.entity.offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

    List<Offer> findByDueDate(LocalDate dueDate);

    List<Offer> findByContractPeriodFromBetween(LocalDate startDate, LocalDate endDate);

    Offer findByOfferToken(String token);


    @Query("select o from Offer o join o.candidate c where c.id=:id")
    List<Offer> findByCandidateId(Integer id);
}
