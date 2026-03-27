package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.reserva.request.ReservaCreatedRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.reserva.request.ReservaUpdatedRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.ReservaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@Tag(name = "Reserva", description = "CRUD de reservas.")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<DefaultGenericResponseDto<List<ReservaResponseDto>>> getAllReservas(){
        List<ReservaResponseDto> reservaResponseDtos = reservaService.getAll();
        DefaultGenericResponseDto<List<ReservaResponseDto>> response = DefaultGenericResponseDto.success(
                reservaResponseDtos.isEmpty() ?
                        "Nenhuma reserva encontrada." : "Reservas encontradas com sucesso.",
                reservaResponseDtos
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('GESTOR')")
    public ResponseEntity<DefaultGenericResponseDto<ReservaResponseDto>> delete(@PathVariable Long id){
        ReservaResponseDto reservaResponseDto = reservaService.delete(id);
        DefaultGenericResponseDto<ReservaResponseDto> response = DefaultGenericResponseDto.success(
                "Reserva deletada com sucesso.",
                reservaResponseDto
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DefaultGenericResponseDto<ReservaResponseDto>> create(
            @RequestBody @Valid ReservaCreatedRequestDto reservaCreatedRequestDto
            ){
        ReservaResponseDto reservaResponseDto = reservaService.create(reservaCreatedRequestDto);
        DefaultGenericResponseDto<ReservaResponseDto> response = DefaultGenericResponseDto.success(
                "Reserva criada com sucesso.",
                reservaResponseDto
        );

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservaResponseDto.codigo())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
