package com.zup.propostas.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Renegociacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String renegociacaoApiId;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataDeCriacao;

    @Deprecated
    public Renegociacao(){}

    public Renegociacao(String renegociacaoApiId, Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.renegociacaoApiId = renegociacaoApiId;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }
}
