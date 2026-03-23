package com.githubguilhermeyeager.salasapi.application.dtos;

public record FieldErrorResponseDto(
        String field,
        String message
) {
}
