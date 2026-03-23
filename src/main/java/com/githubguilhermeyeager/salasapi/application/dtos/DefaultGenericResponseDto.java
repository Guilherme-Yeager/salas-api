package com.githubguilhermeyeager.salasapi.application.dtos;

import java.time.LocalDateTime;

public record DefaultGenericResponseDto<T>(
        boolean success,
        String message,
        LocalDateTime timestamp,
        T data
) {
    public static <T> DefaultGenericResponseDto<T> success(String message, T data) {
        return new DefaultGenericResponseDto<>(true, message, LocalDateTime.now(), data);
    }

    public static <T> DefaultGenericResponseDto<T> error(String message) {
        return new DefaultGenericResponseDto<>(false, message, LocalDateTime.now(), null);
    }
}