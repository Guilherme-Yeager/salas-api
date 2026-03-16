package com.guilhermecode.reserva_salas_api.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

}
