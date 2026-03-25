package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "Home", description = "Operações para ping.")
public class HomeController {

    @GetMapping
    public ResponseEntity<DefaultGenericResponseDto<String>> home(){
        return ResponseEntity.ok(DefaultGenericResponseDto.success(
                "SalasAPI disponível.",
                "Bem-vindo!"
        ));
    }
}
