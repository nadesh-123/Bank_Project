package com.HireTrack.controller;

import com.HireTrack.dto.ApplicationResponse;
import com.HireTrack.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applications")
public class ApplicationController {
   private final ApplicationService applicationService;
    @PostMapping("/applyJob/{jobId}")
    public void applyJob(Principal principal, @PathVariable int jobId){
        String username=principal.getName();

        applicationService.saveApplication(username,jobId);
    }
    @GetMapping("/my-applications")
    public List<ApplicationResponse> viewApplication(Principal principal, @RequestParam(defaultValue = "0",required = false) int page, @RequestParam(defaultValue = "10",required = false) int size){
        String username=principal.getName();
     return    applicationService.findMyApplications(username,page,size);
    }
}
