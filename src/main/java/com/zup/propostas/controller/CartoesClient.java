package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.CartaoApiResponse;
import com.zup.propostas.controller.dto.OrdemBloqueioApiRequest;
import com.zup.propostas.controller.dto.OrdemBloqueioApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "cartoes", url = "${accounts.host}")
public interface CartoesClient {
    @GetMapping("${accounts.associaCartao}")
    CartaoApiResponse buscaCartaoParaAssociar(@RequestParam String idProposta);

    @PostMapping("${accounts.bloqueiaCartao}")
    OrdemBloqueioApiResponse bloqueiaCartao(@PathVariable String id, @RequestBody OrdemBloqueioApiRequest request);
}
