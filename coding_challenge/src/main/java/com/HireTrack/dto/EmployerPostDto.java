package com.HireTrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployerPostDto(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        String password,
        @NotNull
        @NotBlank
        String companyName
) {
}
