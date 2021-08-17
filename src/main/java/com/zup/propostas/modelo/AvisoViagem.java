package com.zup.propostas.modelo;

import com.zup.propostas.controller.dto.AvisoCartaoApiResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class AvisoViagem {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate validoAte;
    private String destino;

    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public AvisoViagem(){}

    public AvisoViagem(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public AvisoViagem(AvisoCartaoApiResponse avisoCartaoApiResponse) {
        this.validoAte = avisoCartaoApiResponse.getValidoAte();
        this.destino = avisoCartaoApiResponse.getDestino();
    }
}
