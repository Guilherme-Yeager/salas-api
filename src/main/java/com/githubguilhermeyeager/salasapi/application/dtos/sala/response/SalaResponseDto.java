package com.githubguilhermeyeager.salasapi.application.dtos.sala.response;

public record SalaResponseDto(
        Long salaId,
        String nome,
        int capacidade,
        String status
) {}
