package com.githubguilhermeyeager.salasapi.mappers;

import com.githubguilhermeyeager.salasapi.dtos.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.dtos.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.models.Sala;
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
