package com.githubguilhermeyeager.salasapi.application.dtos.reserva.response;

import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;

public record ReservaResponseDto (

        Long codigo,

        String horaInicio,

        String horaFim,

        String dataReserva,

        SalaResponseDto sala,

        UsuarioDetailsResponseDto usuario
) { }
