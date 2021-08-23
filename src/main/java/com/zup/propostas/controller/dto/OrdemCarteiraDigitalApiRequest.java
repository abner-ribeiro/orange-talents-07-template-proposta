package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.TipoCarteira;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemCarteiraDigitalApiRequest {
    @NotBlank
    private String email;
    @NotNull
    private TipoCarteira carteira;

    public OrdemCarteiraDigitalApiRequest(String email, TipoCarteira carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public String getEmail() {
        return email;
    }

    public TipoCarteira getCarteira() {
        return carteira;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCarteira(TipoCarteira carteira) {
        this.carteira = carteira;
    }
}
