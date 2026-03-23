package com.githubguilhermeyeager.salasapi.application.mappers;

import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.domain.models.Reserva;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

    List<ReservaResponseDto> reservasToReservaResponseDtos(List<Reserva> reserva);
}
