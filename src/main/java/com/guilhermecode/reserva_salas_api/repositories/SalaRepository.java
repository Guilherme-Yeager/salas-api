package com.guilhermecode.reserva_salas_api.repositories;

import com.guilhermecode.reserva_salas_api.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> { }
