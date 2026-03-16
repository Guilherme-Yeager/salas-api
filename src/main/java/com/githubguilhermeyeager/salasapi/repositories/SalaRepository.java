package com.githubguilhermeyeager.salasapi.repositories;

import com.githubguilhermeyeager.salasapi.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    boolean existsByNome(String nome);
}
