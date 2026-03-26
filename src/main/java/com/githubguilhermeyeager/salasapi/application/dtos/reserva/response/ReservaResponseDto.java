package com.githubguilhermeyeager.salasapi.application.dtos.reserva.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaResponseDto (

        Long codigo,

        @JsonFormat(pattern = "HH:mm")
        LocalTime horaInicio,

        @JsonFormat(pattern = "HH:mm")
        LocalTime horaFim,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataReserva,

        SalaResponseDto sala,

        UsuarioDetailsResponseDto usuario
) { }
