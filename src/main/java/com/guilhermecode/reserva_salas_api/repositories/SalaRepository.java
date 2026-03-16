package com.guilhermecode.reserva_salas_api.repositories;

import com.guilhermecode.reserva_salas_api.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    boolean existsByNome(String nome);
}
