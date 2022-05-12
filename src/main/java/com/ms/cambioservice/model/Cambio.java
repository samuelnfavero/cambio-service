package com.ms.cambioservice.model;

import com.ms.cambioservice.dto.CambioRequest;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "cambio")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_currency",nullable = false , length = 3)
    private String moneyFrom;
    @Column(name = "to_currency",nullable = false, length = 3)
    private String moneyTo;
    @Column(nullable = false)
    private BigDecimal conversionFactor;
    @Transient
    private BigDecimal convertedValue;
    @Transient
    private String enviroment;

    public Cambio(CambioRequest cambioRequest) {
        this.moneyFrom = cambioRequest.getFrom();
        this.moneyTo = cambioRequest.getTo();
    }


}
