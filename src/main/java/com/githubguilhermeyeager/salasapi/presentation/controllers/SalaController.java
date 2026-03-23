package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;


    @GetMapping
    public ResponseEntity<DefaultGenericResponseDto<List<SalaResponseDto>>> getAll() {
        List<SalaResponseDto> salasResponseDto = salaService.getAll();
        DefaultGenericResponseDto<List<SalaResponseDto>> response = DefaultGenericResponseDto.success(
                !salasResponseDto.isEmpty() ? "Salas encontradas com sucesso." : "Nenhuma sala encontrada.",
                salasResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultGenericResponseDto<SalaResponseDto>> get(@PathVariable Long id) {
        SalaResponseDto salaResponseDto = salaService.get(id);
        DefaultGenericResponseDto<SalaResponseDto> response = DefaultGenericResponseDto.success(
                "Sala encontrada com sucesso.",
                salaResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DefaultGenericResponseDto<SalaResponseDto>> create(@RequestBody @Valid SalaRequestDto salaRequestDto) {
        SalaResponseDto salaResponseDto = salaService.create(salaRequestDto);
        DefaultGenericResponseDto<SalaResponseDto> response = DefaultGenericResponseDto.success(
                "Sala criada com sucesso.",
                salaResponseDto
        );

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salaResponseDto.salaId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
