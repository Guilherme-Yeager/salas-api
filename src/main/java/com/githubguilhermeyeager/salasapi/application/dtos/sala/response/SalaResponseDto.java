package com.githubguilhermeyeager.salasapi.application.dtos.sala.response;


public record SalaResponseDto(
        Long codigo,
        String nome,
        int capacidade,
        String status
) {}
