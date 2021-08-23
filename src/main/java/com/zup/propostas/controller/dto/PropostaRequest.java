package com.zup.propostas.controller.dto;

import com.zup.propostas.annotation.CpfCnpj;
import com.zup.propostas.modelo.Proposta;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaRequest {
    @NotBlank @CpfCnpj
    private String documento;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @Positive @NotNull
    private BigDecimal salario;

    public PropostaRequest(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Proposta toModel(){
        return new Proposta(documento,email,nome,endereco,salario);
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }
}
