package com.guilhermecode.reserva_salas_api.mappers;

import com.guilhermecode.reserva_salas_api.dtos.ReservaRequestDto;
import com.guilhermecode.reserva_salas_api.dtos.ReservaResponseDto;
import com.guilhermecode.reserva_salas_api.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

    @Mapping(source = "sala", target = "salaDto")
    ReservaResponseDto reservaToReservaResponseDto(Reserva reserva);

    List<ReservaResponseDto> reservasToReservasResponseDto(List<Reserva> reservas);

    @Mapping(source = "id_sala", target = "sala.id")
    Reserva reservaRequestDtoToReserva(ReservaRequestDto reservaRequestDto);
}
