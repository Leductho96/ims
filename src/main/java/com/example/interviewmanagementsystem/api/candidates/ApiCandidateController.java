package com.example.interviewmanagementsystem.api.candidates;

import com.example.interviewmanagementsystem.service.candidates.CandidatesService;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidatePositionDTO;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidateRecruiterDTO;
import com.example.interviewmanagementsystem.util.dto.candidates.CandidatesListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candidates")
public class ApiCandidateController {

    private final CandidatesService candidatesService;

    @GetMapping
    public Page<CandidatesListDTO> getEmployees(@RequestParam(defaultValue = "1", required = false, value = "pageIndex") Integer pageIndex,
                                                @RequestParam(defaultValue = "5", required = false, value = "pageSize") Integer pageSize,
                                                @RequestParam(required = false, value = "search") String search,
                                                @RequestParam(required = false, value = "field") String field) {

        return candidatesService.getPageCandidates(pageIndex, pageSize, search, field);
    }

    @GetMapping("/position/{id}")
    public CandidatePositionDTO candidatePositionDTO(@PathVariable Integer id){

        return candidatesService.getPagePosition(id);
    }

    @GetMapping("/recruiter/{id}")
    public CandidateRecruiterDTO candidateRecruiterDTO(@PathVariable Integer id){

        return candidatesService.getPageRecruiter(id);
    }

}
