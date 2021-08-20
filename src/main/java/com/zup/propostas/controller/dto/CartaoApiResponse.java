package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CartaoApiResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private List<BloqueioCartaoApiResponse> bloqueios;
    private List<AvisoCartaoApiResponse> avisos;
    private List<CarteiraCartaoApiResponse> carteiras;
    private List<ParcelaCartaoApiResponse> parcelas;
    private BigDecimal limite;
    private RenegociacaoCartaoApiResponse renegociacao;
    private VencimentoCartaoApiResponse vencimento;
    private String idProposta;

    public CartaoApiResponse(String id, LocalDateTime emitidoEm, String titular, List<BloqueioCartaoApiResponse> bloqueios, List<AvisoCartaoApiResponse> avisos, List<CarteiraCartaoApiResponse> carteiras, List<ParcelaCartaoApiResponse> parcelas, BigDecimal limite, RenegociacaoCartaoApiResponse renegociacao, VencimentoCartaoApiResponse vencimento, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    public Cartao toModel(){
       return new Cartao(id,emitidoEm,titular,limite);
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public List<BloqueioCartaoApiResponse> getBloqueios() {
        return bloqueios;
    }

    public List<AvisoCartaoApiResponse> getAvisos() {
        return avisos;
    }

    public List<CarteiraCartaoApiResponse> getCarteiras() {
        return carteiras;
    }

    public List<ParcelaCartaoApiResponse> getParcelas() {
        return parcelas;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public RenegociacaoCartaoApiResponse getRenegociacao() {
        return renegociacao;
    }

    public VencimentoCartaoApiResponse getVencimento() {
        return vencimento;
    }

    public String getIdProposta() {
        return idProposta;
    }

    @Override
    public String toString() {
        return "CartaoApiResponse{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", bloqueios=" + bloqueios +
                ", avisos=" + avisos +
                ", carteiras=" + carteiras +
                ", parcelas=" + parcelas +
                ", limite=" + limite +
                ", renegociacao=" + renegociacao +
                ", vencimento=" + vencimento +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
