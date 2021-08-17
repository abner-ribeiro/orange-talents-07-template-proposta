package com.zup.propostas.controller.dto;

import java.time.LocalDate;

public class AvisoCartaoApiResponse {
    private LocalDate validoAte;
    private String destino;

    public AvisoCartaoApiResponse(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}
