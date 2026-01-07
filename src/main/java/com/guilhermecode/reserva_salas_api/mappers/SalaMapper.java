package com.guilhermecode.reserva_salas_api.mappers;

import com.guilhermecode.reserva_salas_api.dtos.SalaDto;
import com.guilhermecode.reserva_salas_api.models.Sala;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    SalaDto salaToSalaDto(Sala sala);

    Sala salaDtoToSala(SalaDto salaDto);

    List<SalaDto> salasToSalaDtos(List<Sala> sala);

    List<Sala> salaDtosToSalas(List<SalaDto> salaDto);
}
