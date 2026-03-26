package com.githubguilhermeyeager.salasapi.application.mappers;

import com.githubguilhermeyeager.salasapi.application.dtos.usario.request.UsuarioRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.domain.models.Usuario;
import com.githubguilhermeyeager.salasapi.domain.models.enums.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {Role.class})
public interface UsuarioMapper {

    @Mapping(target = "codigo", source = "id")
    UsuarioDetailsResponseDto usuarioToUsuarioDetailsDto(Usuario usuario);

    @Mapping(target = "role", expression = "java(Role.fromNumero(usuarioRequestDto.role()))")
    Usuario usuarioRequestDtoToUsuario(UsuarioRequestDto usuarioRequestDto);
}
