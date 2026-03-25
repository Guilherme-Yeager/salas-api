package com.githubguilhermeyeager.salasapi.domain.repositories;

import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;

import java.util.List;

public interface SalaRepository {

    SalaResponseDto get(Long id);

    List<SalaResponseDto> getAll();

    SalaResponseDto create(SalaRequestDto salaRequestDto);
}
