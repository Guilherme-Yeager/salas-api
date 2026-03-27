package com.githubguilhermeyeager.salasapi.application.dtos.usario.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCreatedRequestDto(

        @NotBlank
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String nome,

        @Email
        @NotBlank
        @Size(max = 30, message = "O nome deve ter no máximo 30 caracteres.")
        String email,

        int role
) {
}
