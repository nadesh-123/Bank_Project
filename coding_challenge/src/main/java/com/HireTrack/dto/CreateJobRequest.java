package com.HireTrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateJobRequest(
        @NotNull
        @NotBlank
        String title,
        @NotNull
        @NotBlank
     String description,
        @NotNull
        @NotBlank
     String location,
        @NotNull

     double salary) {
}
