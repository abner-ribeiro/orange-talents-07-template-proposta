package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.Renegociacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

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

    public Renegociacao toModel() {
        return new Renegociacao(id,quantidade,valor,dataDeCriacao);
    }
}
