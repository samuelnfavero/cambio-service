package com.ms.cambioservice.controller;

import com.ms.cambioservice.dto.CambioRequest;
import com.ms.cambioservice.dto.CambioResponse;
import com.ms.cambioservice.model.Cambio;
import com.ms.cambioservice.service.CambioService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    private final Environment enviroment;

    private final CambioService cambioService;


    public CambioController(Environment enviroment, CambioService cambioService) {
        this.enviroment = enviroment;
        this.cambioService = cambioService;
    }

    @GetMapping("/{amount}/{from}/{to}")
    public CambioResponse getCambio(
            @PathVariable("amount") BigDecimal amount,
            @PathVariable("from") String from,
            @PathVariable("to") String to){
        return cambioService.getCambio(new CambioRequest(from, to, amount));
    }

//    @GetMapping
//    public CambioResponse getCambio(@RequestBody CambioRequest cambioRequest){
//        return cambioService.getCambio(cambioRequest);
//    }
}
