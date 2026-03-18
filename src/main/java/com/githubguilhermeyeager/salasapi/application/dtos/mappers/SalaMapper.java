package com.githubguilhermeyeager.salasapi.application.dtos.mappers;

import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.domain.models.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    Sala salaDtoToSala(SalaRequestDto salaRequestDto);

    @Mapping(source = "id", target = "salaId")
    SalaResponseDto salaToSalaResponseDto(Sala sala);

    List<SalaResponseDto> salasToSalasReponseDto(List<Sala> salas);
}
