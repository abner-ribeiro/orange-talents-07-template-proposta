package com.zup.propostas.controller.dto;

import java.math.BigDecimal;

public class ParcelaCartaoApiResponse {
    private String id;
    private Integer quantidade;
    private BigDecimal valor;

    public ParcelaCartaoApiResponse(String id, Integer quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
