package com.githubguilhermeyeager.salasapi.application.dtos.reserva.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaCreatedRequestDto(

        @NotNull(message = "Hora inicial é obrigatória")
        @Schema(description = "Hora de início do uso da sala.", example = "08:00")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaInicio,

        @NotNull(message = "Hora final é obrigatória")
        @Schema(description = "Hora de término do uso da sala.", example = "12:00")
        @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
        LocalTime horaFim,

        @NotNull(message = "Data é obrigatória")
        @Schema(description = "Data de reserva da sala.", example = "12/06/2025")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataReserva,

        @NotNull(message = "Sala é obrigatória")
        @Schema(description = "Código da sala.", example = "1")
        @Positive
        Long idSala,

        @Schema(description = "Código da usuário que reservou a sala.", example = "46")
        @Positive
        Long idUsuario
) { }
