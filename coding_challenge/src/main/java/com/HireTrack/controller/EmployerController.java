package com.HireTrack.controller;

import com.HireTrack.dto.EmployerPostDto;
import com.HireTrack.service.EmployerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employer")
public class EmployerController {
  private final  EmployerService employerService;
    @PostMapping("/addEmployer")
    public void postEmployer(@Valid  @RequestBody EmployerPostDto employerPostDto){
        employerService.postEmployer(employerPostDto);
    }

}
