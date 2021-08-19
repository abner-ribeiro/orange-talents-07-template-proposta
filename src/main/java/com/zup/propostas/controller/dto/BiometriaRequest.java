package com.zup.propostas.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zup.propostas.modelo.Biometria;
import com.zup.propostas.modelo.Cartao;
import com.zup.propostas.modelo.DedoEmBase64;

import javax.validation.constraints.NotBlank;

public class BiometriaRequest {
    @NotBlank
    private String dedo;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BiometriaRequest(String dedo) {
        this.dedo = dedo;
    }

    public Biometria toModel(Cartao cartao){
        return new Biometria(new DedoEmBase64(dedo),cartao);
    }

    public String getDedo() {
        return dedo;
    }
}
