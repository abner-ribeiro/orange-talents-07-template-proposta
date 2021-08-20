package com.zup.propostas.controller.dto;

import javax.validation.constraints.NotBlank;

public class OrdemBloqueioApiRequest {
    @NotBlank
    private String sistemaResponsavel;

    public OrdemBloqueioApiRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
