package com.githubguilhermeyeager.salasapi.controllers;

import com.githubguilhermeyeager.salasapi.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

}
