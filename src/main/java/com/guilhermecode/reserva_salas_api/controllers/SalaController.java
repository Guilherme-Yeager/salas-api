package com.guilhermecode.reserva_salas_api.controllers;

import com.guilhermecode.reserva_salas_api.dtos.SalaDto;
import com.guilhermecode.reserva_salas_api.mappers.SalaMapper;
import com.guilhermecode.reserva_salas_api.models.Sala;
import com.guilhermecode.reserva_salas_api.models.enums.Status;
import com.guilhermecode.reserva_salas_api.services.SalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private SalaMapper salaMapper;

    @GetMapping
    public List<SalaDto> getAll() {
        List<Sala> salas = salaService.getAll();
        return salaMapper.salasToSalaDtos(salas);
    }

    @PostMapping
    public ResponseEntity<SalaDto> create(@RequestBody @Valid SalaDto salaDto) {
        Sala sala = salaMapper.salaDtoToSala(salaDto);
        sala.setStatus(Status.DISPONIVEL);
        salaService.create(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaMapper.salaToSalaDto(sala));
    }
}
