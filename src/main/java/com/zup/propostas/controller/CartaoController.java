package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.*;
import com.zup.propostas.modelo.*;
import com.zup.propostas.repository.AvisoViagemRepository;
import com.zup.propostas.repository.BiometriaRepository;
import com.zup.propostas.repository.BloqueioRepository;
import com.zup.propostas.repository.CartaoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private CartoesClient cartoesClient;
    @Autowired
    private AvisoViagemRepository avisoViagemRepository;

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

        try{
            OrdemBloqueioApiRequest bloqueioRequest = new OrdemBloqueioApiRequest("Proposta");
            cartoesClient.bloqueiaCartao(numeroCartao,bloqueioRequest);
        }catch (FeignException e){
            System.out.println("excecao: "+e);
            return ResponseEntity.internalServerError().build();
        }
        bloqueioRepository.save(bloqueio);
        cartao.bloqueiaCartao();
        cartaoRepository.save(cartao);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{numeroCartao}/avisos")
    public ResponseEntity avisoViagem(@PathVariable String numeroCartao,@RequestBody @Valid AvisoViagemRequest avisoViagemRequest, HttpServletRequest request){
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

        try{
            OrdemAvisoViagemApiRequest ordemAvisoViagemApiRequest = new OrdemAvisoViagemApiRequest(avisoViagemRequest.getDestinoViagem(),avisoViagemRequest.getTerminoViagem());
            cartoesClient.avisaViagem(numeroCartao,ordemAvisoViagemApiRequest);
        }catch (FeignException e){
            System.out.println("excecao: "+e);
            return ResponseEntity.internalServerError().build();
        }

        AvisoViagem avisoViagem = avisoViagemRequest.toModel(ipAddress,userAgent,cartao);
        avisoViagemRepository.save(avisoViagem);

        return ResponseEntity.ok().build();
    }
}
