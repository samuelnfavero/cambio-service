package com.ms.cambioservice.model;

import com.ms.cambioservice.dto.CambioRequest;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Document("cambio")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Cambio implements Serializable {

    @Id
    private ObjectId id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String enviroment;

    public Cambio(CambioRequest cambioRequest) {
        this.from = cambioRequest.getFrom();
        this.to = cambioRequest.getTo();
        this.conversionFactor = cambioRequest.getConversionFactor();

    }
}
