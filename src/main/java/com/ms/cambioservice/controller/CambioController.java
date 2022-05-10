package com.ms.cambioservice.controller;

import com.ms.cambioservice.model.Cambio;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    private final Environment enviroment;

    public CambioController(Environment enviroment) {
        this.enviroment = enviroment;
    }

    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to){

        var port = enviroment.getProperty("local.server.port");
        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
    }
}
