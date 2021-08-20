package com.zup.propostas.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RenegociacaoCartaoApiResponse {
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataDeCriacao;

    public RenegociacaoCartaoApiResponse(String id, Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }
}
