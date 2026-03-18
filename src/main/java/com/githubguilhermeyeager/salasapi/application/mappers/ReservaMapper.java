package com.githubguilhermeyeager.salasapi.application.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

}
