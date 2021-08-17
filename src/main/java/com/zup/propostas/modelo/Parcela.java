package com.zup.propostas.modelo;

import com.zup.propostas.controller.dto.ParcelaCartaoApiResponse;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parcelaApiId;
    private Integer quantidade;
    private BigDecimal valor;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Parcela(){}

    public Parcela(String parcelaApiId, Integer quantidade, BigDecimal valor) {
        this.parcelaApiId = parcelaApiId;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Parcela(ParcelaCartaoApiResponse parcelaCartaoApiResponse) {
        this.parcelaApiId = parcelaCartaoApiResponse.getId();
        this.quantidade = parcelaCartaoApiResponse.getQuantidade();
        this.valor = parcelaCartaoApiResponse.getValor();
    }
}
