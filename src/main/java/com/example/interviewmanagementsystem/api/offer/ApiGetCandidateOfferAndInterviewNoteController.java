package com.example.interviewmanagementsystem.api.offer;

import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.service.candidates.CandidatesService;
import com.example.interviewmanagementsystem.service.interview.InterviewService;
import com.example.interviewmanagementsystem.service.offer.OfferService;
import com.example.interviewmanagementsystem.util.dto.offer.DepartmentListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferCandidateListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferListDTO;
import com.example.interviewmanagementsystem.util.dto.offer.OfferUserListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageDepartment;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class ApiGetCandidateOfferAndInterviewNoteController {

    private final CandidatesService candidatesService;
    private final InterviewService interviewService;
    private final OfferService offerService;

    @GetMapping("/candidate/{id}")
    public List<Interview> getListInterviewByCandidateId(@PathVariable Integer id) {
        return interviewService.getListInterviewByCandidateId(id);
    }

    @GetMapping("/candidateEmail/{id}")
    public Optional<Candidates> getCandidateByCandidateId(@PathVariable Integer id) {
        return candidatesService.findByCandidateId(id);
    }

    @GetMapping("/interview/{id}")
    public Optional<Interview> getInterview(@PathVariable Integer id) {
        return interviewService.findById(id);
    }

    @GetMapping("/interviewer/{id}")
    public List<Interviewer> getInterviewerList(@PathVariable Integer id) {
        return interviewService.findListInterviewerByInterviewId(id);
    }
    @GetMapping
    public Page<OfferListDTO> getOfferviews(@RequestParam(defaultValue = "1",required = false,value = "pageIndex")Integer pageIndex,
                                            @RequestParam(defaultValue = "5",required = false,value = "pageSize") Integer pageSize,
                                            @RequestParam(required = false,value="search") String search,
                                            @RequestParam(required = false,value = "department") String department,
                                            @RequestParam(required = false,value = "status") String status, Model model){
        return offerService.getPageOffer(pageIndex,pageSize,search,department,status);
    }

    @GetMapping("/user/{id}")
    public OfferUserListDTO offerUserListDTO(@PathVariable Integer id){
        return offerService.getPageUser(id);
    }

    @GetMapping("/candidateDTO/{id}")
    public OfferCandidateListDTO offerCandidateListDTO(@PathVariable Integer id){
        return offerService.getPageCandidate(id);
    }

    @GetMapping("/department/{id}")
    public PageDepartment<DepartmentListDTO> offerDepartmentDTO(@PathVariable Integer id){
        return offerService.getPageDepartment(id);
    }
}
