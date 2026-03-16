package com.githubguilhermeyeager.salasapi.services;

import com.githubguilhermeyeager.salasapi.dtos.SalaRequestDto;
import com.githubguilhermeyeager.salasapi.dtos.SalaResponseDto;
import com.githubguilhermeyeager.salasapi.exceptions.ConflictException;
import com.githubguilhermeyeager.salasapi.exceptions.NotFoundException;
import com.githubguilhermeyeager.salasapi.mappers.SalaMapper;
import com.githubguilhermeyeager.salasapi.models.Sala;
import com.githubguilhermeyeager.salasapi.models.enums.Status;
import com.githubguilhermeyeager.salasapi.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public SalaResponseDto get(Long id) {
        return salaRepository
                .findById(id)
                .map(salaMapper::salaToSalaResponseDto)
                .orElseThrow(() -> new NotFoundException("Sala não encontrada."));
    }

    public List<SalaResponseDto> getAll() {
        return salaMapper.salasToSalasReponseDto(salaRepository.findAll());
    }

    public SalaResponseDto create(SalaRequestDto salaRequestDto) {
        if(salaRepository.existsByNome(salaRequestDto.nome())){
            throw new ConflictException("Já existe uma sala com esse nome.");
        }

        Sala sala = salaMapper.salaDtoToSala(salaRequestDto);
        sala.setStatus(Status.DISPONIVEL);
        return salaMapper.salaToSalaResponseDto(salaRepository.save(sala));
    }
}
