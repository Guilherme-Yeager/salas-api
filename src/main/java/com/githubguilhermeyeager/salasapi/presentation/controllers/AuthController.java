package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.requests.LoginRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.responses.LoginResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<DefaultGenericResponseDto<LoginResponseDto>> login(
            @RequestBody @Valid LoginRequestDto loginRequestDto
    ) {
        LoginResponseDto loginResponseDto = usuarioService.logar(loginRequestDto);
        DefaultGenericResponseDto<LoginResponseDto> response = DefaultGenericResponseDto.success(
                "Login efetuado com sucesso.",
                loginResponseDto
        );
        return ResponseEntity.ok(response);
    }
}
