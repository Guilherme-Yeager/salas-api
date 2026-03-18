package com.githubguilhermeyeager.salasapi.presentation.controllers;

import com.githubguilhermeyeager.salasapi.infrastructure.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

}
