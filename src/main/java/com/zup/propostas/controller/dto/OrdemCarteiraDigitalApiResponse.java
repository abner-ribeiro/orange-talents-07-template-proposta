package com.zup.propostas.controller.dto;

public class OrdemCarteiraDigitalApiResponse {
    private String resultado;
    private String id;

    public OrdemCarteiraDigitalApiResponse(String resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrdemCarteiraDigitalApiResponse{" +
                "resultado='" + resultado + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
