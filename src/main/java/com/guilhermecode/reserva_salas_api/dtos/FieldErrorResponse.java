package com.guilhermecode.reserva_salas_api.dtos;

public record FieldErrorResponse(
        String field,
        String message
) {
}
