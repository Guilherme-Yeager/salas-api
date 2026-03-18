package com.githubguilhermeyeager.salasapi.application.dtos.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

}
