package com.ms.cambioservice.dto;

import com.ms.cambioservice.model.Cambio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@AllArgsConstructor @Getter
public class CambioResponse {
    private ObjectId id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String enviroment;

    public CambioResponse(Cambio cambio){
        this.id = cambio.getId();
        this.from = cambio.getFrom();
        this.to = cambio.getTo();
        this.conversionFactor = cambio.getConversionFactor();
        this.convertedValue = cambio.getConvertedValue();
        this.enviroment = cambio.getEnviroment();
    }
}