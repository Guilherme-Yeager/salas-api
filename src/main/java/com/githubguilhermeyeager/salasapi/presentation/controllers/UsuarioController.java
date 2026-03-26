package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.request.UsuarioRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuário", description = "Operações para o gerenciamento de usuários.")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/search")
    @Validated
    public ResponseEntity<DefaultGenericResponseDto<UsuarioDetailsResponseDto>> get(
            @RequestParam @Email String email
    ){
        UsuarioDetailsResponseDto usuarioDetailsResponseDto = usuarioService.findByEmail(email);
        DefaultGenericResponseDto<UsuarioDetailsResponseDto> response = DefaultGenericResponseDto.success(
                "Usuário encontrado com sucesso.",
                usuarioDetailsResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<DefaultGenericResponseDto<List<UsuarioDetailsResponseDto>>> findAll(){
        List<UsuarioDetailsResponseDto> usuarioDetailsResponseDto = usuarioService.findAll();
        DefaultGenericResponseDto<List<UsuarioDetailsResponseDto>> response = DefaultGenericResponseDto.success(
                usuarioDetailsResponseDto.isEmpty() ?
                "Nenhum usuário encontrado." : "Usuários encontrados com sucesso.",
                usuarioDetailsResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DefaultGenericResponseDto<UsuarioDetailsResponseDto>> create(
            @RequestBody @Valid UsuarioRequestDto usuarioRequestDto
    ){
        UsuarioDetailsResponseDto usuarioDetailsResponseDto = usuarioService.create(usuarioRequestDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioDetailsResponseDto.codigo())
                .toUri();

        DefaultGenericResponseDto<UsuarioDetailsResponseDto> response = DefaultGenericResponseDto.success(
                "Usuário criado com sucesso.",
                usuarioDetailsResponseDto
        );

        return ResponseEntity.created(uri).body(response);
    }
}
