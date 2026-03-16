package com.guilhermecode.reserva_salas_api.services;

import com.guilhermecode.reserva_salas_api.dtos.SalaRequestDto;
import com.guilhermecode.reserva_salas_api.dtos.SalaResponseDto;
import com.guilhermecode.reserva_salas_api.exceptions.ConflictException;
import com.guilhermecode.reserva_salas_api.exceptions.NotFoundException;
import com.guilhermecode.reserva_salas_api.mappers.SalaMapper;
import com.guilhermecode.reserva_salas_api.models.Sala;
import com.guilhermecode.reserva_salas_api.models.enums.Status;
import com.guilhermecode.reserva_salas_api.repositories.SalaRepository;
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
