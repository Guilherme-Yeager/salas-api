package com.githubguilhermeyeager.salasapi.domain.models;

import com.githubguilhermeyeager.salasapi.domain.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int capacidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

}
