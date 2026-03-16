package com.guilhermecode.reserva_salas_api.dtos;

public record SalaResponseDto(
        Long salaId,
        String nome,
        int capacidade,
        String status
) {}
