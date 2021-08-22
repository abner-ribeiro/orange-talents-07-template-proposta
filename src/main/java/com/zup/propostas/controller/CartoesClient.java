package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "cartoes", url = "${accounts.host}")
public interface CartoesClient {
    @GetMapping("${accounts.associaCartao}")
    CartaoApiResponse buscaCartaoParaAssociar(@RequestParam String idProposta);

    @PostMapping("${accounts.bloqueiaCartao}")
    OrdemBloqueioApiResponse bloqueiaCartao(@PathVariable String id, @RequestBody OrdemBloqueioApiRequest request);

    @PostMapping("${accounts.avisaViagemCartao}")
    OrdemAvisoViagemApiResponse avisaViagem(@PathVariable String id, OrdemAvisoViagemApiRequest ordemAvisoViagemApiRequest);
}
