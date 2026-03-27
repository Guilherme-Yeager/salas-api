package com.githubguilhermeyeager.salasapi.application.mappers;

import com.githubguilhermeyeager.salasapi.application.dtos.reserva.request.ReservaCreatedRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.domain.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SalaMapper.class, UsuarioMapper.class})
public interface ReservaMapper {

    @Mappings({
            @Mapping(source = "id", target = "codigo"),
            @Mapping(source = "horaInicio", target = "horaInicio", dateFormat = "HH:mm"),
            @Mapping(source = "horaFim", target = "horaFim", dateFormat = "HH:mm"),
            @Mapping(source = "dataReserva", target = "dataReserva", dateFormat = "dd/MM/yyyy")
    })
    ReservaResponseDto reservaToReservaResponseDto(Reserva reserva);

    List<ReservaResponseDto> reservasToReservaResponseDtos(List<Reserva> reserva);

    Reserva reservaCreatedRequestDtoToReserva(ReservaCreatedRequestDto reservaCreatedRequestDto);
}
