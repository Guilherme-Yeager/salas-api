package com.githubguilhermeyeager.salasapi.infrastructure.repositories;

import com.githubguilhermeyeager.salasapi.domain.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r JOIN FETCH r.sala")
    List<Reserva> findAllWithSala();
}
