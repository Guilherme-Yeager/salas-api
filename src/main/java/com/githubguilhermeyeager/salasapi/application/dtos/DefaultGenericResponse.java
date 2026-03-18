package com.githubguilhermeyeager.salasapi.application.dtos;

import java.time.LocalDateTime;

public record DefaultGenericResponse<T>(
        boolean success,
        String message,
        LocalDateTime timestamp,
        T data
) {
    public static <T> DefaultGenericResponse<T> success(String message, T data) {
        return new DefaultGenericResponse<>(true, message, LocalDateTime.now(), data);
    }

    public static <T> DefaultGenericResponse<T> error(String message) {
        return new DefaultGenericResponse<>(false, message, LocalDateTime.now(), null);
    }
}