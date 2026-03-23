package com.githubguilhermeyeager.salasapi.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalTime horaInicio;

    private LocalTime horaFim;

    @Column(nullable = false)
    private LocalDate dataReserva;

    @ManyToOne
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala sala;
}
