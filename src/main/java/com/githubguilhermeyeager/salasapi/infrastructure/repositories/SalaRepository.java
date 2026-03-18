package com.githubguilhermeyeager.salasapi.infrastructure.repositories;

import com.githubguilhermeyeager.salasapi.domain.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    boolean existsByNome(String nome);
}
