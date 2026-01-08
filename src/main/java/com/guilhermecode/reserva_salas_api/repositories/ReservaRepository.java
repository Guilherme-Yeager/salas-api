package com.guilhermecode.reserva_salas_api.repositories;

import com.guilhermecode.reserva_salas_api.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("""
                SELECT COUNT(r) > 0
                FROM Reserva r
                WHERE r.sala.id = :salaId
                  AND r.dataReserva = :data
                  AND (
                        :horaInicio < r.horaFim
                    AND :horaFim > r.horaInicio
                  )
            """)
    boolean isReserved(
            @Param("salaId") Long salaId,
            @Param("data") LocalDate data,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFim") LocalTime horaFim
    );

}
