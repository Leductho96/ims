package com.example.interviewmanagementsystem.service.offer.impl;

import com.example.interviewmanagementsystem.config.security.SecurityUtils;
import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.offer.Offer;
import com.example.interviewmanagementsystem.repository.offer.Impl.OfferRepositoryCustomImpl;
import com.example.interviewmanagementsystem.repository.offer.OfferRepository;
import com.example.interviewmanagementsystem.service.file.FileStorageService;
import com.example.interviewmanagementsystem.service.offer.OfferService;
import com.example.interviewmanagementsystem.util.dto.offer.DepartmentListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferCandidateListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferUserListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageDepartment;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final JavaMailSender javaMailSender;
    private final FileStorageService fileLocalCandidateService;
    private final OfferRepositoryCustomImpl offerRepositoryCustom;

    @Override
    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    @Override
    public List<Offer> findByDueDate(LocalDate date) {
        return offerRepository.findByDueDate(date);
    }

    @Override
    public Optional<Offer> findById(Integer id) {
        return offerRepository.findById(id);
    }


    @Override
    public void sendEmail(String recipientEmail, Offer offer, String link) throws MessagingException, UnsupportedEncodingException {

        String dueDate = offer.getDueDate().toString();
        String interviewTitle = offer.getInterviewInfo().getJobs().getTitle();
        String candidateName = offer.getCandidate().getFullName();
        String candidatePosition = offer.getCandidate().getPosition().getPositionName();
        String recruiterAccount = offer.getRecruiterOwner().getRecruiterUserName();
        String fileCvName = offer.getCandidate().getCvAttachment();

        File file = new File(fileLocalCandidateService.getFileLocation() + "/" + fileCvName);
        FileSystemResource fileAttach = new FileSystemResource(file);

        String subject = "no-reply-email-IMS-system " + interviewTitle;
        String content = "<p>This email is from IMS system,</p>" +
                "<p>You have an offer to take action For Candidate " + candidateName + "</p>" +
                "<p>position " + candidatePosition + " before " + dueDate + ", the contract is</p>" +
                "<p>attached with this no-reply-email</p>" +
                "<p>Please refer this link to take action " + link + "</p>" +
                "<p>If anything wrong, please reach-out recruiter " + recruiterAccount + "</p>" +
                "<p> We are so sorry for this inconvenience.</p>" +
                "<p>Thanks & Regards!</p>" +
                "<p>IMS Team.</p>";

        MimeMessagePreparator preparator = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setTo(recipientEmail);
            message.setFrom("fjb04@fa.com", "FA Support");
            message.setSubject(subject);
            message.setText(content, true);
            message.addAttachment("file CV", fileAttach);
        };

        try {
            javaMailSender.send(preparator);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> findAllByDate(LocalDate startDate, LocalDate endDate) {
        return offerRepository.findByContractPeriodFromBetween(startDate, endDate);
    }
    @Override
    public Page<OfferListDTO> getPageOffer(Integer pageIndex, Integer pageSize, String search, String department, String status) {
        List<OfferListDTO> offerList=offerRepositoryCustom.getOfferPage(pageIndex,pageSize,search,department,status);
        int pageTotal=(int)Math.ceil(offerRepositoryCustom.getAllOffer(search,department,status).size() * 1.0/pageSize);
        String role= SecurityUtils.getCurrentRole().toString();
        Page<OfferListDTO> page=new Page<>(pageTotal,pageIndex,offerList,pageSize,role);
        return page;
    }

    @Override
    public PageDepartment<DepartmentListDTO> getPageDepartment(Integer id) {
        List<DepartmentListDTO> departmentListDTOS=offerRepositoryCustom.getDepartmentById(id);
        PageDepartment<DepartmentListDTO>pageDepartment=new PageDepartment<>(departmentListDTOS);
        return pageDepartment;
    }

    @Override
    public OfferUserListDTO getPageUser(Integer id) {
        return offerRepositoryCustom.getUserById(id);
    }

    @Override
    public OfferCandidateListDTO getPageCandidate(Integer id) {
        return offerRepositoryCustom.getCandidateById(id);
    }

    @Override
    public Offer findByOfferToken(String token) {
        return offerRepository.findByOfferToken(token);
    }

    @Override
    public void sendEmailToCandidate(Candidates candidate, String offerLink) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("hr@imssystem.com" ,"FA Human Resources");
        helper.setTo(candidate.getEmail());

        String subject = "Job Offer for " + candidate.getFullName();

        String content =
                "<p>We would like to send an job offer for <span>\"" + candidate.getFullName() + "\"</span></p>"
                        +"<p>Please click <a href=\"" + offerLink + "\">here</a> to see details of the offer</p>"
                        +"<p>In order to we can receive your response, please click on ACCEPT OFFER or REJECT OFFER in offer detail form.</p>"
                        +"<p>Thanks & Regards!</p>"
                        +"<p>IMS HR Team.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        javaMailSender.send(message);
    }
}
