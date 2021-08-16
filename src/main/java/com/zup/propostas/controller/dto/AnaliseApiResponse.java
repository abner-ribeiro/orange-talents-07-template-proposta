package com.zup.propostas.controller.dto;

import com.zup.propostas.modelo.ResultadoSolicitacao;

public class AnaliseApiResponse {
    private String documento;
    private String nome;
    private ResultadoSolicitacao resultadoSolicitacao;
    private String idProposta;

    public AnaliseApiResponse(String documento, String nome, ResultadoSolicitacao resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public ResultadoSolicitacao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    @Override
    public String toString() {
        return "AnaliseApiResponse{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", resultadoSolicitacao=" + resultadoSolicitacao +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
