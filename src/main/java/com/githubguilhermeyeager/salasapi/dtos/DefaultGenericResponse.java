package com.githubguilhermeyeager.salasapi.dtos;

public record DefaultGenericResponse<T>(
        boolean success,
        String message,
        T data
) {
    public static <T> DefaultGenericResponse<T> success(String message, T data) {
        return new DefaultGenericResponse<>(true, message, data);
    }

    public static <T> DefaultGenericResponse<T> error(String message) {
        return new DefaultGenericResponse<>(false, message, null);
    }
}