package com.zup.propostas.modelo;

import com.zup.propostas.annotation.CpfCnpj;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @CpfCnpj
    private String documento;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @Positive
    @NotNull
    private BigDecimal salario;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    @OneToOne(cascade = {CascadeType.MERGE})
    private Cartao cartao;


    @Deprecated
    public Proposta(){};

    public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.status = StatusProposta.NAO_ELEGIVEL;
    }

    public void atualizaStatus(ResultadoSolicitacao resultadoSolicitacao) {
        this.status = resultadoSolicitacao.getStatusProposta();
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void associaCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public StatusProposta getStatus() {
        return status;
    }
}
