package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.usario.response.UsuarioDetailsResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}
