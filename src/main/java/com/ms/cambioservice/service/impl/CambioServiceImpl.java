package com.ms.cambioservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.cambioservice.dto.CambioRequest;
import com.ms.cambioservice.dto.CambioResponse;
import com.ms.cambioservice.model.Cambio;
import com.ms.cambioservice.repository.CambioRepository;
import com.ms.cambioservice.service.CambioService;
import org.springframework.stereotype.Service;

@Service
public class CambioServiceImpl implements CambioService {

    private final CambioRepository cambioRepository;

    public CambioServiceImpl(CambioRepository cambioRepository, ObjectMapper mapper) {
        this.cambioRepository = cambioRepository;
    }

    @Override
    public CambioResponse create(CambioRequest cambioRequest) {

        Cambio cambio = new Cambio(cambioRequest);
        Cambio savedCambio = cambioRepository.save(cambio);
        return new CambioResponse(savedCambio);
    }
}
