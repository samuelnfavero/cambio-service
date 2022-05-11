package com.ms.cambioservice.model;

import com.ms.cambioservice.dto.CambioRequest;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "cambio")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Cambio implements Serializable {



    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String moneyFrom;
    @Column
    private String moneyTo;
    @Column
    private BigDecimal conversionFactor;
    @Column
    private BigDecimal convertedValue;
    @Column
    private String enviroment;

    public Cambio(CambioRequest cambioRequest) {
        this.moneyFrom = cambioRequest.getFrom();
        this.moneyTo = cambioRequest.getTo();
        this.conversionFactor = cambioRequest.getConversionFactor();

    }


}
