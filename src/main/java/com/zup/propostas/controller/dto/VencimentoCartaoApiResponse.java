package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.Vencimento;

import java.time.LocalDateTime;

public class VencimentoCartaoApiResponse {
    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    public VencimentoCartaoApiResponse(String id, Integer dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public Vencimento toModel() {
        return new Vencimento(id,dia,dataDeCriacao);
    }
}
