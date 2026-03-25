package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.application.dtos.sala.request.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.sala.response.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.domain.exceptions.ConflictException;
import com.githubguilhermeyeager.salasapi.domain.exceptions.NotFoundException;
import com.githubguilhermeyeager.salasapi.application.mappers.SalaMapper;
import com.githubguilhermeyeager.salasapi.domain.models.Sala;
import com.githubguilhermeyeager.salasapi.domain.models.enums.Status;
import com.githubguilhermeyeager.salasapi.domain.repositories.SalaRepository;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.SalaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceJpa implements SalaRepository {

    @Autowired
    private SalaRepositoryJpa salaRepositoryJpa;

    @Autowired
    private SalaMapper salaMapper;

    public SalaResponseDto get(Long id) {
        return salaRepositoryJpa
                .findById(id)
                .map(salaMapper::salaToSalaResponseDto)
                .orElseThrow(() -> new NotFoundException("Sala não encontrada."));
    }

    public List<SalaResponseDto> getAll() {
        return salaMapper.salasToSalasReponseDto(salaRepositoryJpa.findAll());
    }

    public SalaResponseDto create(SalaRequestDto salaRequestDto) {
        if(salaRepositoryJpa.existsByNome(salaRequestDto.nome())){
            throw new ConflictException("Já existe uma sala com esse nome.");
        }

        Sala sala = salaMapper.salaDtoToSala(salaRequestDto);
        sala.setStatus(Status.DISPONIVEL);
        return salaMapper.salaToSalaResponseDto(salaRepositoryJpa.save(sala));
    }
}
