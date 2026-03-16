package com.guilhermecode.reserva_salas_api.controllers;

import com.guilhermecode.reserva_salas_api.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

}
