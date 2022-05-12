package com.ms.cambioservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor @Getter
public class CambioRequest {
    private String from;
    private String to;
    private BigDecimal amount;
}
