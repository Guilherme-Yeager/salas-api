package com.githubguilhermeyeager.salasapi.application.dtos.reserva.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaUpdatedRequestDto (

        @NotNull(message = "Hora inicial é obrigatória")
        @DateTimeFormat(pattern = "HH:mm")
        LocalTime horaInicio,

        @NotNull(message = "Hora final é obrigatória")
        @DateTimeFormat(pattern = "HH:mm")
        LocalTime horaFim,

        @NotNull(message = "Data é obrigatória")
        @Future(message = "A data deve ser futura")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate dataReserva
){
}
