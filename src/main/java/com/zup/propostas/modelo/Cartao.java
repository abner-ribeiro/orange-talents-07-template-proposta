package com.zup.propostas.modelo;

import com.zup.propostas.controller.dto.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Bloqueio> bloqueios = new ArrayList<>();

    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AvisoViagem> avisos = new ArrayList<>();

    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CarteiraDigital> carteiras = new ArrayList<>();

    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Parcela> parcelas = new ArrayList<>();

    private BigDecimal limite;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Renegociacao renegociacao;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Vencimento vencimento;

    @Deprecated
    public Cartao(){}

    public Cartao(String numeroCartao, LocalDateTime emitidoEm, String titular, List<Bloqueio> bloqueios, List<AvisoViagem> avisos, List<CarteiraDigital> carteiras, List<Parcela> parcelas, BigDecimal limite, Renegociacao renegociacao, Vencimento vencimento) {
        this.numeroCartao = numeroCartao;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
    }

}
