package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.application.mappers.ReservaMapper;
import com.githubguilhermeyeager.salasapi.domain.repositories.ReservaRepository;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.ReservaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService implements ReservaRepository {

    @Autowired
    private ReservaRepositoryJpa reservaRepositoryJpa;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaResponseDto> getAll() {
        return reservaMapper.reservasToReservaResponseDtos(reservaRepositoryJpa.findAllWithSala());
    }
}
