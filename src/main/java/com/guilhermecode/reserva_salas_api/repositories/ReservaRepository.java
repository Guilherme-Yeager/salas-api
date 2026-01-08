package com.guilhermecode.reserva_salas_api.repositories;

import com.guilhermecode.reserva_salas_api.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> { }
