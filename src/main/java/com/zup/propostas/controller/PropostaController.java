package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.AnaliseApiRequest;
import com.zup.propostas.controller.dto.AnaliseApiResponse;
import com.zup.propostas.controller.dto.PropostaRequest;
import com.zup.propostas.modelo.Proposta;
import com.zup.propostas.modelo.ResultadoSolicitacao;
import com.zup.propostas.repository.PropostaRepository;
import com.zup.propostas.validacao.ErroDeFormularioDto;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private ConsultaDadosSolicitante consultaDadosSolicitante;

    @PostMapping
    @Transactional
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
            AnaliseApiResponse analiseApiResponse = consultaDadosSolicitante.consultaDados(analiseApiRequest);
            proposta.atualizaStatus(analiseApiResponse.getResultadoSolicitacao());
        }catch (FeignException e){
            proposta.atualizaStatus(ResultadoSolicitacao.COM_RESTRICAO);
        }

        URI uri = uriComponentsBuilder.path("propostas/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
