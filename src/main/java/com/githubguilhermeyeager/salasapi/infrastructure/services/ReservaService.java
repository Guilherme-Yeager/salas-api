package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.application.dtos.reserva.request.ReservaCreatedRequestDto;
import com.githubguilhermeyeager.salasapi.application.dtos.reserva.response.ReservaResponseDto;
import com.githubguilhermeyeager.salasapi.application.mappers.ReservaMapper;
import com.githubguilhermeyeager.salasapi.domain.exceptions.NotFoundException;
import com.githubguilhermeyeager.salasapi.domain.models.Reserva;
import com.githubguilhermeyeager.salasapi.domain.models.Sala;
import com.githubguilhermeyeager.salasapi.domain.models.Usuario;
import com.githubguilhermeyeager.salasapi.domain.repositories.ReservaRepository;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.ReservaRepositoryJpa;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.SalaRepositoryJpa;
import com.githubguilhermeyeager.salasapi.infrastructure.repositories.UsuarioRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservaService implements ReservaRepository {

    @Autowired
    private ReservaRepositoryJpa reservaRepositoryJpa;

    @Autowired
    private UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Autowired
    private SalaRepositoryJpa salaRepositoryJpa;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaResponseDto> getAll() {
        return reservaMapper.reservasToReservaResponseDtos(reservaRepositoryJpa.findAllWithSala());
    }

    public ReservaResponseDto delete(Long id) {
        Reserva reserva  = reservaRepositoryJpa.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva não encontrada."));
        reservaRepositoryJpa.delete(reserva);
        return reservaMapper.reservaToReservaResponseDto(reserva);
    }

    public ReservaResponseDto create(ReservaCreatedRequestDto reservaCreatedRequestDto) {
        Reserva reserva = reservaMapper.reservaCreatedRequestDtoToReserva(reservaCreatedRequestDto);

        Usuario usuario = usuarioRepositoryJpa.findById(reservaCreatedRequestDto.idUsuario())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        Sala sala = salaRepositoryJpa.findById(reservaCreatedRequestDto.idSala())
                .orElseThrow(() -> new NotFoundException("Sala não encontrada."));

        reserva.setUsuario(usuario);
        reserva.setSala(sala);

        Reserva reservaSalva = reservaRepositoryJpa.save(reserva);

        return reservaMapper.reservaToReservaResponseDto(reservaSalva);
    }
}
