package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.BiometriaRequest;
import com.zup.propostas.modelo.Biometria;
import com.zup.propostas.modelo.Bloqueio;
import com.zup.propostas.modelo.Cartao;
import com.zup.propostas.modelo.StatusCartao;
import com.zup.propostas.repository.BiometriaRepository;
import com.zup.propostas.repository.BloqueioRepository;
import com.zup.propostas.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private BiometriaRepository biometriaRepository;
    @Autowired
    private BloqueioRepository bloqueioRepository;

    @PostMapping("/{numeroCartao}/biometrias")
    public ResponseEntity cadastrar(@PathVariable String numeroCartao, @RequestBody @Valid BiometriaRequest biometriaRequest, UriComponentsBuilder uriComponentsBuilder){
        Optional<Cartao> possivelCartao = cartaoRepository.findByNumeroCartao(numeroCartao);

        if(possivelCartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Cartao cartao = possivelCartao.get();
        Biometria biometria = biometriaRequest.toModel(cartao);

        biometriaRepository.save(biometria);

        URI uri = uriComponentsBuilder.path("/biometrias/{id}").buildAndExpand(biometria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PostMapping("/{numeroCartao}/bloqueios")
    public ResponseEntity bloquear(@PathVariable String numeroCartao, HttpServletRequest request){
        Optional<Cartao> possivelCartao = cartaoRepository.findByNumeroCartao(numeroCartao);

        String userAgent = request.getHeader("User-Agent");
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        if(possivelCartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Cartao cartao = possivelCartao.get();
        if(cartao.getStatus() == StatusCartao.BLOQUEADO){
            return ResponseEntity.unprocessableEntity().build();
        }
        Bloqueio bloqueio = new Bloqueio(ipAddress,userAgent,cartao);

        bloqueioRepository.save(bloqueio);
        cartao.bloqueiaCartao();
        cartaoRepository.save(cartao);
        
        return ResponseEntity.ok().build();
    }
}
