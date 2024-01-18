package com.example.interviewmanagementsystem.api.jobs;

import com.example.interviewmanagementsystem.service.jobs.JobService;
import com.example.interviewmanagementsystem.util.dto.jobs.JobsListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.LevelListDTO;
import com.example.interviewmanagementsystem.util.dto.jobs.SkillListDTO;
import com.example.interviewmanagementsystem.util.page.Page;
import com.example.interviewmanagementsystem.util.page.PageLevel;
import com.example.interviewmanagementsystem.util.page.PageSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class ApiJobsController {

    private final JobService jobService;

    @GetMapping
    public Page<JobsListDTO> getEmployees(
            @RequestParam(defaultValue = "1",required = false, value="pageIndex") Integer pageIndex,
            @RequestParam(defaultValue = "7", required = false, value="pageSize") Integer pageSize,
            @RequestParam(required = false, value="search") String search,
            @RequestParam(required = false, value="status") String status) {

        return jobService.getPageJob(pageIndex, pageSize, search, status);
    }

    @GetMapping("/skills/{id}")
    public PageSkill<SkillListDTO> getSkill(@PathVariable Integer id) {

        return jobService.getPageSkill(id);
    }

    @GetMapping("/levels/{id}")
    public PageLevel<LevelListDTO> getLevel(@PathVariable Integer id) {

        return jobService.getPageLevel(id);
    }
}
