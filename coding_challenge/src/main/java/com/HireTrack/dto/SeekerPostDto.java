package com.HireTrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SeekerPostDto(
        @NotNull
        @NotBlank
        String username,
        @NotNull
        @NotBlank
        String password,
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String email,
        @NotNull
        @NotBlank
        String resumeSummary) {
}
