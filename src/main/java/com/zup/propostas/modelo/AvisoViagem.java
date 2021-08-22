package com.zup.propostas.modelo;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AvisoViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String destinoViagem;
    @NotNull
    @Future
    private LocalDate terminoViagem;
    @NotNull
    private LocalDateTime avisadoEm = LocalDateTime.now();
    @NotBlank
    private String ipOrigem;
    @NotBlank
    private String userAgent;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public AvisoViagem(){}

    public AvisoViagem(String destinoViagem, LocalDate terminoViagem, String ipOrigem, String userAgent, Cartao cartao) {
        this.destinoViagem = destinoViagem;
        this.terminoViagem = terminoViagem;
        this.ipOrigem = ipOrigem;
        this.userAgent = userAgent;
        this.cartao = cartao;
    }
}
