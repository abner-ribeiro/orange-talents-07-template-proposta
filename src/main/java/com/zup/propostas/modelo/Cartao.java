package com.zup.propostas.modelo;

import com.zup.propostas.controller.dto.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;

    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;

    private BigDecimal limite;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusCartao status;

    @Deprecated
    public Cartao(){}

    public Cartao(String numeroCartao, LocalDateTime emitidoEm, String titular, BigDecimal limite) {
        this.numeroCartao = numeroCartao;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.status = StatusCartao.ATIVO;
    }

    public void bloqueiaCartao(){
        this.status = StatusCartao.BLOQUEADO;
    }

    public StatusCartao getStatus() {
        return status;
    }

}
