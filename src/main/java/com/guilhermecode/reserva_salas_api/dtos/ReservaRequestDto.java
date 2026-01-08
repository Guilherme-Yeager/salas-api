package com.guilhermecode.reserva_salas_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaRequestDto(

        @NotNull(message = "Hora inicial é obrigatória")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaInicio,

        @NotNull(message = "Hora final é obrigatória")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaFim,

        @NotNull(message = "Data é obrigatória")
        @Future(message = "A data deve ser futura")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataReserva,

        @NotNull(message = "Sala é obrigatória")
        @Positive
        Long id_sala
) { }
