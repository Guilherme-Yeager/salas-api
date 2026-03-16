package com.githubguilhermeyeager.salasapi.services;

import com.githubguilhermeyeager.salasapi.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

}
