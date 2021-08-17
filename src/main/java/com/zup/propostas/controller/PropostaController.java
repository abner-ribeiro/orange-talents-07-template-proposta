package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.*;
import com.zup.propostas.modelo.Cartao;
import com.zup.propostas.modelo.Proposta;
import com.zup.propostas.modelo.ResultadoSolicitacao;
import com.zup.propostas.repository.PropostaRepository;
import com.zup.propostas.validacao.ErroDeFormularioDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private AnaliseFinanceiraClient analiseFinanceiraClient;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid PropostaRequest propostaRequest, UriComponentsBuilder uriComponentsBuilder){
        Optional<Proposta> possivelProposta = propostaRepository.findByDocumento(propostaRequest.getDocumento());

        if(possivelProposta.isPresent()){
            ErroDeFormularioDto erro = new ErroDeFormularioDto("documento","Já existe uma proposta cadastrada para esse CPF/CNPJ");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
        }

        Proposta proposta = propostaRequest.toModel();
        propostaRepository.save(proposta);

        try {
            AnaliseApiRequest analiseApiRequest = new AnaliseApiRequest(proposta);
            AnaliseApiResponse analiseApiResponse = analiseFinanceiraClient.consultaDados(analiseApiRequest);
            proposta.atualizaStatus(analiseApiResponse.getResultadoSolicitacao());
        }catch (FeignException e){
            proposta.atualizaStatus(ResultadoSolicitacao.COM_RESTRICAO);
        }
        propostaRepository.save(proposta);

        URI uri = uriComponentsBuilder.path("propostas/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity encontrar(@PathVariable Long id){
        Optional<Proposta> possivelProposta = propostaRepository.findById(id);
        if(possivelProposta.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        PropostaResponse propostaResponse = new PropostaResponse(possivelProposta.get());
        return ResponseEntity.ok().body(propostaResponse);
    }
}
