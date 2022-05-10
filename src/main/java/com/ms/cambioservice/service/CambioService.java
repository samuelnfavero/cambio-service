package com.ms.cambioservice.service;

import com.ms.cambioservice.dto.CambioRequest;
import com.ms.cambioservice.dto.CambioResponse;

public interface CambioService {
    CambioResponse create(CambioRequest cambioRequest);
}
