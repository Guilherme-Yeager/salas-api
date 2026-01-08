package com.guilhermecode.reserva_salas_api.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public record SalaDto (

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Min(value = 1, message = "Capacidade mínima é 1")
        int capacidade,

        String status
) {}
