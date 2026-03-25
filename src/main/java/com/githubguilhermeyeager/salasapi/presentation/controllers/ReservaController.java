package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.infrastructure.services.ReservaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
