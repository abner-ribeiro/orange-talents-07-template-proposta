package com.zup.propostas.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String dedo;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Biometria(){}

    public Biometria(DedoEmBase64 dedo, Cartao cartao) {
        this.dedo = dedo.getDedo();
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }
}
