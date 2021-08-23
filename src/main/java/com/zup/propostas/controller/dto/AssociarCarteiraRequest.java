package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.Cartao;
import com.zup.propostas.modelo.Carteira;
import com.zup.propostas.modelo.StatusCarteira;
import com.zup.propostas.modelo.TipoCarteira;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AssociarCarteiraRequest {
    @NotBlank
    private String email;
    @NotNull
    private TipoCarteira tipoCarteira;

    public AssociarCarteiraRequest(String email, TipoCarteira tipoCarteira) {
        this.email = email;
        this.tipoCarteira = tipoCarteira;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }

    public String getEmail() {
        return email;
    }

    public Carteira toModel(Cartao cartao){
        return new Carteira(tipoCarteira, cartao);
    }
}
