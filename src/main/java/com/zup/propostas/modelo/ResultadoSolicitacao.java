package com.zup.propostas.modelo;

import org.springframework.web.util.UriComponentsBuilder;

public enum ResultadoSolicitacao {
    COM_RESTRICAO{
        StatusProposta getStatusProposta(){
            return StatusProposta.NAO_ELEGIVEL;
        }
    }, SEM_RESTRICAO{
        StatusProposta getStatusProposta(){
            return StatusProposta.ELEGIVEL;
        }
    };

    abstract StatusProposta getStatusProposta();
}
