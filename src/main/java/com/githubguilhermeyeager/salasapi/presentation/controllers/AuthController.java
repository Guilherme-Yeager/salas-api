package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.requests.LoginRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.login.responses.LoginResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.TokenService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<DefaultGenericResponseDto<LoginResponseDto>> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = tokenService.gerarToken(loginRequestDto.email());
        DefaultGenericResponseDto<LoginResponseDto> response = DefaultGenericResponseDto.success(
                "Token gerado com sucesso.",
                loginResponseDto
        );
        return ResponseEntity.ok(response);
    }
}
