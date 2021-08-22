package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.AvisoViagem;
import com.zup.propostas.modelo.Cartao;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvisoViagemRequest {
    @NotBlank
    private String destinoViagem;
    @NotNull @Future
    private LocalDate terminoViagem;

    public AvisoViagemRequest(String destinoViagem, LocalDate terminoViagem) {
        this.destinoViagem = destinoViagem;
        this.terminoViagem = terminoViagem;
    }

    public AvisoViagem toModel(String ip, String userAgent, Cartao cartao){
        return new AvisoViagem(destinoViagem,terminoViagem,ip,userAgent,cartao);
    }

    public String getDestinoViagem() {
        return destinoViagem;
    }

    public LocalDate getTerminoViagem() {
        return terminoViagem;
    }
}
