package com.guilhermecode.reserva_salas_api.services;

import com.guilhermecode.reserva_salas_api.models.Sala;
import com.guilhermecode.reserva_salas_api.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> getAll(){
        return salaRepository.findAll();
    }

    public int create(Sala sala){
        return salaRepository.save(sala).getId();
    }
}
