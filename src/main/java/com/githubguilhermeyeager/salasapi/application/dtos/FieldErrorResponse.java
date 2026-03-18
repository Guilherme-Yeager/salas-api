package com.githubguilhermeyeager.salasapi.application.dtos;

public record FieldErrorResponse(
        String field,
        String message
) {
}
