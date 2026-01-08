package com.guilhermecode.reserva_salas_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
        SalaDto salaDto
) { }
