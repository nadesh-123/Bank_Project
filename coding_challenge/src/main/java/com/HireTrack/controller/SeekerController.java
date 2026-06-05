package com.HireTrack.controller;

import com.HireTrack.dto.SeekerPostDto;
import com.HireTrack.service.SeekerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/seeker")
public class SeekerController {
   private final SeekerService seekerService;
    @PostMapping("/addSeeker")
    public void postSeeker(@Valid  @RequestBody SeekerPostDto seekerPostDto){
        seekerService.postSeeker(seekerPostDto);
    }


}
