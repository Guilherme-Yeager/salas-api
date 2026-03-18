package com.githubguilhermeyeager.salasapi.infrastructure.services;

import com.githubguilhermeyeager.salasapi.infrastructure.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

}
