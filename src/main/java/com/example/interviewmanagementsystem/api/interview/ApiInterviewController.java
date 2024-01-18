package com.example.interviewmanagementsystem.api.interview;
import com.example.interviewmanagementsystem.service.interview.InterviewService;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewCandidateDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewJobDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewListDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewerListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageInterviewer;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/interview")
public class ApiInterviewController {

    private final InterviewService interviewService;


    @GetMapping
    public Page<InterviewListDTO> getInterviews(@RequestParam(defaultValue = "1", required = false, value = "pageIndex") Integer pageIndex,
                                                @RequestParam(defaultValue = "5", required = false, value = "pageSize") Integer pageSize,
                                                @RequestParam(required = false, value = "search") String search,
                                                @RequestParam(required = false, value = "interviewer") String interviewer,
                                                @RequestParam(required = false, value = "status") String status, Model model) {

        return interviewService.getPageInterview(pageIndex, pageSize, search, interviewer, status);
    }

    @GetMapping("/candidate/{id}")
    public InterviewCandidateDTO interviewCandidateDTO (@PathVariable Integer id) {
        return interviewService.getPageCandidate(id);
    }

    @GetMapping("/interviewer/{id}")
    public PageInterviewer<InterviewerListDTO> interviewInterviewerDTO (@PathVariable Integer id) {

        return interviewService.getPageInterviewer(id);
    }

    @GetMapping("/job/{id}")
    public InterviewJobDTO interviewJobDTO (@PathVariable Integer id) {
        return interviewService.getPageJob(id);
    }
}
