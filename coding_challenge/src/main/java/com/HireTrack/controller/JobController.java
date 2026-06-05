package com.HireTrack.controller;

import com.HireTrack.dto.JobResponse;
import com.HireTrack.dto.CreateJobRequest;
import com.HireTrack.service.JobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/job")
public class JobController {
    private final JobService jobService;
    @PostMapping("/addJob")
    public void postJob(@Valid @RequestBody CreateJobRequest jobPostDto, Principal principal){
        String username=principal.getName();
        jobService.saveJob(username,jobPostDto);
    }
    @GetMapping("/getAllJobs")
    public List<JobResponse> getAllJobs(@RequestParam(defaultValue = "0",required = false) int page, @RequestParam(defaultValue = "10",required = false) int size){
        return jobService.getAllJobs(page,size);
    }
}
