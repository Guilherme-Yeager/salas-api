package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.application.dtos.login.requests.LoginRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.responses.LoginResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.application.mappers.UsuarioMapper;
import com.githubguilhermeyeager.salasapi.domain.exceptions.NotFoundException;
import com.githubguilhermeyeager.salasapi.domain.models.Usuario;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public LoginResponseDto logar(LoginRequestDto dto) {
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication auth = authenticationManager.authenticate(credentials);
        Usuario usuario = Optional.ofNullable(auth.getPrincipal())
                .filter(Usuario.class::isInstance)
                .map(Usuario.class::cast)
                .orElseThrow(() -> new AuthenticationServiceException("Erro ao processar usuário autenticado."));

        return tokenService.gerarToken(usuario);
    }

    public UsuarioDetailsResponseDto findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        return usuarioMapper.usuarioToUsuarioDetailsDto(usuario);
    }
}
