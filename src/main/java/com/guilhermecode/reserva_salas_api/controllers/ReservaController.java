package com.guilhermecode.reserva_salas_api.controllers;

import com.guilhermecode.reserva_salas_api.dtos.ReservaRequestDto;
import com.guilhermecode.reserva_salas_api.dtos.ReservaResponseDto;
import com.guilhermecode.reserva_salas_api.mappers.ReservaMapper;
import com.guilhermecode.reserva_salas_api.models.Reserva;
import com.guilhermecode.reserva_salas_api.models.Sala;
import com.guilhermecode.reserva_salas_api.services.ReservaService;
import com.guilhermecode.reserva_salas_api.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private ReservaMapper reservaMapper;

    @GetMapping
    public List<ReservaResponseDto> getAll() {
        List<Reserva> reservas = reservaService.getAll();
        return reservaMapper.reservasToReservasResponseDto(reservas);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDto> create(@RequestBody @Valid ReservaRequestDto reservaRequestDto) throws Exception {
        Reserva reserva = reservaMapper.reservaRequestDtoToReserva(reservaRequestDto);
        Sala sala = salaService.get(reserva.getSala().getId());
        reserva.setSala(sala);
        reservaService.create(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaMapper.reservaToReservaResponseDto(reserva));
    }
}
