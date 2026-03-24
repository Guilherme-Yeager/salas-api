package com.githubguilhermeyeager.salasapi.application.dtos.usario.response;

public record UsuarioDetailsResponseDto(
        String nome,
        String email,
        String role
) {
}
