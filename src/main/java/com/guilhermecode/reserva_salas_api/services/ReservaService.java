package com.guilhermecode.reserva_salas_api.services;

import com.guilhermecode.reserva_salas_api.models.Reserva;
import com.guilhermecode.reserva_salas_api.models.Sala;
import com.guilhermecode.reserva_salas_api.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll() {
        return reservaRepository.findAll();
    }

    public Long create(Reserva reserva) {
        boolean isReserved = reservaRepository.isReserved(
                reserva.getSala().getId(),
                reserva.getDataReserva(),
                reserva.getHoraInicio(),
                reserva.getHoraFim()
        );
        if (isReserved) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Horário da sala já está reservado.");
        }
        return reservaRepository.save(reserva).getId();
    }


}
