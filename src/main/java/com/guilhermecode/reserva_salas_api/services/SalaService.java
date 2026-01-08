package com.guilhermecode.reserva_salas_api.services;

import com.guilhermecode.reserva_salas_api.models.Sala;
import com.guilhermecode.reserva_salas_api.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public Sala get(Long id) throws Exception {
        return salaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada"));
    }

    public List<Sala> getAll() {
        return salaRepository.findAll();
    }

    public Long create(Sala sala) {
        return salaRepository.save(sala).getId();
    }
}
