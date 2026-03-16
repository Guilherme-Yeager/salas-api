package com.githubguilhermeyeager.salasapi.dtos;

public record FieldErrorResponse(
        String field,
        String message
) {
}
