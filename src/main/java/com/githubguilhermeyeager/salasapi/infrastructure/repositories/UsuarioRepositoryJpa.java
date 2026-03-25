package com.githubguilhermeyeager.salasapi.infrastructure.repositories;

import com.githubguilhermeyeager.salasapi.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositoryJpa extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
