package com.guilhermecode.reserva_salas_api.services;

import com.guilhermecode.reserva_salas_api.models.Reserva;
import com.guilhermecode.reserva_salas_api.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll(){
        return reservaRepository.findAll();
    }

    public Long create(Reserva reserva){
        return reservaRepository.save(reserva).getId();
    }
}
