package com.zup.propostas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Vencimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vencimentoApiId;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    @Deprecated
    public Vencimento(){}

    public Vencimento(String vencimentoApiId, Integer dia, LocalDateTime dataDeCriacao) {
        this.vencimentoApiId = vencimentoApiId;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }
}
