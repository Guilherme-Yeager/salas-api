package com.guilhermecode.reserva_salas_api.mappers;

import com.guilhermecode.reserva_salas_api.dtos.SalaRequestDto;
import com.guilhermecode.reserva_salas_api.dtos.SalaResponseDto;
import com.guilhermecode.reserva_salas_api.models.Sala;
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
