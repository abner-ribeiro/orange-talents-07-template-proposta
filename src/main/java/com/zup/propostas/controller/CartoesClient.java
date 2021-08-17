package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.CartaoApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cartoes", url = "${accounts.host}")
public interface CartoesClient {
    @GetMapping("${accounts.associaCartao}")
    CartaoApiResponse buscaCartaoParaAssociar(@RequestParam String idProposta);
}
