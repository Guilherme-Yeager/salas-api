package com.githubguilhermeyeager.salasapi.controllers;

import com.githubguilhermeyeager.salasapi.dtos.DefaultGenericResponse;
import com.githubguilhermeyeager.salasapi.dtos.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.dtos.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.services.SalaService;
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
    public ResponseEntity<DefaultGenericResponse<List<SalaResponseDto>>> getAll() {
        List<SalaResponseDto> salasResponseDto = salaService.getAll();
        DefaultGenericResponse<List<SalaResponseDto>> response = DefaultGenericResponse.success(
                !salasResponseDto.isEmpty() ? "Salas encontradas com sucesso." : "Nenhuma sala encontrada.",
                salasResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultGenericResponse<SalaResponseDto>> get(@PathVariable Long id) {
        SalaResponseDto salaResponseDto = salaService.get(id);
        DefaultGenericResponse<SalaResponseDto> response = DefaultGenericResponse.success(
                "Sala encontrada com sucesso.",
                salaResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DefaultGenericResponse<SalaResponseDto>> create(@RequestBody @Valid SalaRequestDto salaRequestDto) {
        SalaResponseDto salaResponseDto = salaService.create(salaRequestDto);
        DefaultGenericResponse<SalaResponseDto> response = DefaultGenericResponse.success(
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
