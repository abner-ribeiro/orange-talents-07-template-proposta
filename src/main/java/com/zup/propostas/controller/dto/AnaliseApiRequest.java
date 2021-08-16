package com.zup.propostas.controller.dto;

import com.zup.propostas.annotation.CpfCnpj;
import com.zup.propostas.modelo.Proposta;

import javax.validation.constraints.NotBlank;

public class AnaliseApiRequest {
    @CpfCnpj
    @NotBlank
    private String documento;

    @NotBlank
    private String nome;

    @NotBlank
    private String idProposta;

    public AnaliseApiRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId().toString();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}
