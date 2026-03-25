package com.githubguilhermeyeager.salasapi.domain.repositories;

import com.githubguilhermeyeager.salasapi.application.dtos.login.requests.LoginRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.responses.LoginResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;

public interface UsarioRepository {

    LoginResponseDto logar(LoginRequestDto dto);

    UsuarioDetailsResponseDto findByEmail(String email);
}
