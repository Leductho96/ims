package com.example.interviewmanagementsystem.scheduler;

import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.entity.offer.Offer;
import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.service.interview.InterviewService;
import com.example.interviewmanagementsystem.service.jobs.JobService;
import com.example.interviewmanagementsystem.service.offer.OfferService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UpdateJobStatusTask {

    private final JobService jobService;
    private final InterviewService interviewService;
    private final OfferService offerService;

    @Scheduled(cron = "0 0 0 * * *")
    public void updateJobStatusTask(){
        jobService.updateJobStatus();
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void sendEmailReminder(){
        try{
            LocalDate dueDate = LocalDate.now();
            List<Interview> interviewList = interviewService.findByInterviewDate(dueDate);
            List<Offer> offerList = offerService.findByDueDate(dueDate);

            for (Interview interview: interviewList){
                Set<Interviewer> interviewers = interview.getInterviewers();

                for (Interviewer inter : interviewers) {
                    String email = inter.getEmail();
                    String link = "http://localhost:8080/interview/view/"+interview.getId();
                    interviewService.sendEmail(email,interview,link);
                }
            }

            for (Offer offer : offerList) {
                User user = offer.getApprovedBy();
                String email = user.getEmail();
                String link = "http://localhost:8080/offer/view/" + offer.getId();
                offerService.sendEmail(email, offer, link);
            }

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
