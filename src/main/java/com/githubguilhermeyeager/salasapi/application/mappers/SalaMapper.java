package com.githubguilhermeyeager.salasapi.application.mappers;

import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.domain.models.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    Sala salaDtoToSala(SalaRequestDto salaRequestDto);

    @Mappings({
            @Mapping(source = "id", target = "codigo"),
            @Mapping(source = "statusAtivo", target = "status"),
    })
    SalaResponseDto salaToSalaResponseDto(Sala sala);

    List<SalaResponseDto> salasToSalasReponseDto(List<Sala> salas);
}
