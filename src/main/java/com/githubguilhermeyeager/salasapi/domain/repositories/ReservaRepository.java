package com.githubguilhermeyeager.salasapi.domain.repositories;

import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;

import java.util.List;

public interface ReservaRepository {

    List<ReservaResponseDto> getAll();
}
