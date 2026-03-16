package com.githubguilhermeyeager.salasapi.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

}
