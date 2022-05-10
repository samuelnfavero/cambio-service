package com.ms.cambioservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Document("cambio")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Cambio implements Serializable {

    @Id
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String enviroment;

}
