package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.application.mappers.ReservaMapper;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaResponseDto> getAll(){
        return reservaMapper.reservasToReservaResponseDtos(reservaRepository.findAllWithSala());
    }
}
