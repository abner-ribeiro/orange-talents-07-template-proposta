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

    private String bloqueioApiId;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private Boolean ativo;
    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Bloqueio(){}

    public Bloqueio(String bloqueioApiId, LocalDateTime bloqueadoEm, String sistemaResponsavel, Boolean ativo) {
        this.bloqueioApiId = bloqueioApiId;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public Bloqueio(BloqueioCartaoApiResponse bloqueioCartaoApiResponse) {
        this.bloqueioApiId = bloqueioCartaoApiResponse.getId();
        this.bloqueadoEm = bloqueioCartaoApiResponse.getBloqueadoEm();
        this.sistemaResponsavel = bloqueioCartaoApiResponse.getSistemaResponsavel();
        this.ativo = bloqueioCartaoApiResponse.getAtivo();
    }

    @Override
    public String toString() {
        return "Bloqueio{" +
                "id=" + id +
                ", bloqueioApiId='" + bloqueioApiId + '\'' +
                ", bloqueadoEm=" + bloqueadoEm +
                ", sistemaResponsavel='" + sistemaResponsavel + '\'' +
                ", ativo=" + ativo +
                ", cartao=" + cartao +
                '}';
    }
}
