package com.example.interviewmanagementsystem.controller.offer;

import com.example.interviewmanagementsystem.entity.offer.Offer;
import com.example.interviewmanagementsystem.enums.offer.OfferStatus;
import com.example.interviewmanagementsystem.service.offer.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class CandidateOfferController {

    private final OfferService offerService;

    @GetMapping("/view-offer")
    public String showOfferByCandidate(@Param(value = "token") String token, Model model) {
        Offer findOffer = offerService.findByOfferToken(token);

        if (Objects.isNull(findOffer)) {
            model.addAttribute("message", "This link doesn't exist. Please try again.");
            return "/login/message";
        }

        model.addAttribute("candidateInfo", findOffer);

        if(findOffer.getOfferStatus().equals(OfferStatus.WAITING_FOR_RESPONSE)) {
            model.addAttribute("acceptButton", "Accept Offer");
            model.addAttribute("declineButton", "Decline Offer");
        }

        return "offer/view-offer";
    }

    @GetMapping("/accept-offer")
    @Transactional
    public String acceptOffer(@Param(value = "token") String token, Model model) {
        Offer offer = offerService.findByOfferToken(token);

        if (Objects.isNull(offer)) {
            model.addAttribute("message", "This link doesn't exist. Please try again.");
            return "/login/message";
        }

        offer.setOfferStatus(OfferStatus.ACCEPTED_OFFER);
        offerService.save(offer);

        return "redirect:/view-offer";
    }

    @GetMapping("/decline-offer")
    @Transactional
    public String declineOffer(@Param(value = "token") String token, Model model) {
        Offer offer = offerService.findByOfferToken(token);

        if (Objects.isNull(offer)) {
            model.addAttribute("message", "This link doesn't exist. Please try again.");
            return "/login/message";
        }

        offer.setOfferStatus(OfferStatus.DECLINED_OFFER);
        offerService.save(offer);

        return "redirect:/view-offer";
    }

}
