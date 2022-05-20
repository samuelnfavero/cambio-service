package com.ms.cambioservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.cambioservice.dto.CambioRequest;
import com.ms.cambioservice.dto.CambioResponse;
import com.ms.cambioservice.model.Cambio;
import com.ms.cambioservice.repository.CambioRepository;
import com.ms.cambioservice.service.CambioService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CambioServiceImpl implements CambioService {

    private final CambioRepository cambioRepository;

    private final Environment environment;

    public CambioServiceImpl(CambioRepository cambioRepository, ObjectMapper mapper, Environment environment) {
        this.cambioRepository = cambioRepository;
        this.environment = environment;
    }

    @Override
    public CambioResponse getCambio(CambioRequest cambioRequest) {

//        Cambio cambio = cambioRepository.findById(2L).get();
        Cambio cambio = cambioRepository.findByMoneyFromAndMoneyTo(cambioRequest.getFrom(), cambioRequest.getTo())
                .orElseThrow(() -> new RuntimeException("Cambio não encontrado"));
        String port = environment.getProperty("local.server.port");
        cambio.setConvertedValue(convertValue(cambioRequest.getAmount(), cambio.getConversionFactor()));
        cambio.setEnviroment(port);
        return new CambioResponse(cambio);
    }

    private BigDecimal convertValue(BigDecimal amount, BigDecimal conversionFactor){
        return amount.multiply(conversionFactor);
    }
}
