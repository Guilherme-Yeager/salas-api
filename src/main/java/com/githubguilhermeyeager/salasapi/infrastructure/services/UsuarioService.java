package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.application.dtos.login.requests.LoginRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.responses.LoginResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.request.UsuarioRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.application.mappers.UsuarioMapper;
import com.githubguilhermeyeager.salasapi.domain.exceptions.ConflictException;
import com.githubguilhermeyeager.salasapi.domain.exceptions.NotFoundException;
import com.githubguilhermeyeager.salasapi.domain.models.Usuario;
import com.githubguilhermeyeager.salasapi.domain.repositories.UsarioRepository;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.UsuarioRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsarioRepository {

    @Autowired
    private UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${spring.defaultPassword}")
    private String defaultPassword;

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
        Usuario usuario = usuarioRepositoryJpa.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        return usuarioMapper.usuarioToUsuarioDetailsDto(usuario);
    }

    public List<UsuarioDetailsResponseDto> findAll() {
        return usuarioRepositoryJpa
                .findAll()
                .stream()
                .map(usuarioMapper::usuarioToUsuarioDetailsDto)
                .toList();
    }

    public  UsuarioDetailsResponseDto create(UsuarioRequestDto usuarioRequestDto) {
        if(usuarioRepositoryJpa.existsByEmail(usuarioRequestDto.email())){
            throw new ConflictException("Já existe um usuário cadastrado com esse email.");
        }

        Usuario usuario = usuarioMapper.usuarioRequestDtoToUsuario(usuarioRequestDto);

        String senha = passwordEncoder.encode(defaultPassword);
        usuario.setSenha(senha);

        Usuario usuarioSalvo = usuarioRepositoryJpa.save(usuario);

        return usuarioMapper.usuarioToUsuarioDetailsDto(usuarioSalvo);
    }
}
