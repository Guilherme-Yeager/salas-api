package com.githubguilhermeyeager.salasapi.application.dtos.login.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto (
        @Email
        String email,
        @NotBlank
        String senha
){
}

