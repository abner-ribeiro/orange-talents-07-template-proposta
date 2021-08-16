package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.AnaliseApiRequest;
import com.zup.propostas.controller.dto.AnaliseApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@FeignClient(name = "solicitacao", url = "http://localhost:9999")
public interface ConsultaDadosSolicitante {

    @PostMapping("/api/solicitacao")
    AnaliseApiResponse consultaDados(@RequestBody @Valid AnaliseApiRequest analiseApiRequest);
}
