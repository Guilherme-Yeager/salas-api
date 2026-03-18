package com.githubguilhermeyeager.salasapi.application.dtos.reserva.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaRequestDto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaResponseDto (

        @JsonFormat(pattern = "HH:mm")
        LocalTime horaInicio,

        @JsonFormat(pattern = "HH:mm")
        LocalTime horaFim,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataReserva,

        @JsonProperty("sala")
        SalaRequestDto salaRequestDto
) { }
