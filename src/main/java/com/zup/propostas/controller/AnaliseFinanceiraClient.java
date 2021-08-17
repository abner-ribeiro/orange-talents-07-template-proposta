package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.AnaliseApiRequest;
import com.zup.propostas.controller.dto.AnaliseApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@FeignClient(name = "solicitacao", url = "${analise-financeira.host}")
public interface AnaliseFinanceiraClient {

    @PostMapping("${analise-financeira.analisa-proposta}")
    AnaliseApiResponse consultaDados(@RequestBody @Valid AnaliseApiRequest analiseApiRequest);
}
