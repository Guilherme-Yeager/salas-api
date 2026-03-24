package com.githubguilhermeyeager.salasapi.application.dtos.login.responses;

public record LoginResponseDto(
        String nome,
        String email,
        String role,
        String token
) {
}
