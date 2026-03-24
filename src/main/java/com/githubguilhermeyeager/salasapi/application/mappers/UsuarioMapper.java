package com.githubguilhermeyeager.salasapi.application.mappers;

import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.domain.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDetailsResponseDto usuarioToUsuarioDetailsDto(Usuario usuario);
}
