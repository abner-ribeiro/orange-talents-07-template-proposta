package com.zup.propostas.controller.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class OrdemAvisoViagemApiRequest {
    @NotBlank
    private String destino;
    @NotNull
    @Future
    private LocalDate validoAte;

    public OrdemAvisoViagemApiRequest(String destino, LocalDate validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }
}
