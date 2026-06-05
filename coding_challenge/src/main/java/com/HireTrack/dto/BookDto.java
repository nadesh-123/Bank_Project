package com.HireTrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        @NotBlank
        @NotNull
        String title,
        @NotBlank
        @NotNull
        String summary) {
}
