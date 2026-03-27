package com.githubguilhermeyeager.salasapi.domain.repositories;

import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaCreatedRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;

import java.util.List;

public interface SalaRepository {

    SalaResponseDto get(Long id);

    List<SalaResponseDto> getAll();

    SalaResponseDto create(SalaCreatedRequestDto salaCreatedRequestDto);
}
