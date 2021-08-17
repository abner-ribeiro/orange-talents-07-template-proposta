package com.zup.propostas.modelo;

import com.zup.propostas.controller.dto.CarteiraCartaoApiResponse;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CarteiraDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carteiraApiId;
    private String email;
    private LocalDateTime associadoEm;
    private String emissor;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public CarteiraDigital(){}

    public CarteiraDigital(String carteiraApiId, String email, LocalDateTime associadoEm, String emissor) {
        this.carteiraApiId = carteiraApiId;
        this.email = email;
        this.associadoEm = associadoEm;
        this.emissor = emissor;
    }

    public CarteiraDigital(CarteiraCartaoApiResponse carteiraCartaoApiResponse) {
        this.carteiraApiId = carteiraCartaoApiResponse.getId();
        this.email = carteiraCartaoApiResponse.getEmail();
        this.associadoEm = carteiraCartaoApiResponse.getAssociadoEm();
        this.emissor = carteiraCartaoApiResponse.getEmissor();
    }
}
