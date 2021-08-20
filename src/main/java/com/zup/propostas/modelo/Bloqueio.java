package com.zup.propostas.modelo;

import com.zup.propostas.controller.dto.BloqueioCartaoApiResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Bloqueio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime bloqueadoEm = LocalDateTime.now();
    @NotBlank
    private String ipOrigem;
    @NotBlank
    private String userAgent;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Bloqueio(){}

    public Bloqueio(String ipOrigem, String userAgent, Cartao cartao) {
        this.ipOrigem = ipOrigem;
        this.userAgent = userAgent;
        this.cartao = cartao;
    }
}
