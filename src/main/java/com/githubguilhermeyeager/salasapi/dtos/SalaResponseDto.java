package com.githubguilhermeyeager.salasapi.dtos;

public record SalaResponseDto(
        Long salaId,
        String nome,
        int capacidade,
        String status
) {}
