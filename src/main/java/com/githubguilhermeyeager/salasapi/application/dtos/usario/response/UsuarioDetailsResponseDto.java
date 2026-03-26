package com.githubguilhermeyeager.salasapi.application.dtos.usario.response;

public record UsuarioDetailsResponseDto(
        Long codigo,
        String nome,
        String email,
        String role
) {
}
