package com.zup.propostas.controller;

import com.zup.propostas.controller.dto.CartaoApiResponse;
import com.zup.propostas.modelo.Cartao;
import com.zup.propostas.modelo.Proposta;
import com.zup.propostas.repository.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleCartao {
    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private CartoesClient cartoesClient;

    @Scheduled(fixedDelay = 50000) //executa a cada 50 segundos (tempo sempre em milisegundos)
    private void associaCartao(){
        List<Proposta> propostasSemCartao = propostaRepository.findEligibleProposesWithoutCard();

        for (Proposta proposta: propostasSemCartao) {
            try {
                CartaoApiResponse cartaoApiResponse = cartoesClient.buscaCartaoParaAssociar(proposta.getId().toString());
                Cartao cartao = cartaoApiResponse.toModel();
                proposta.associaCartao(cartao);
                propostaRepository.save(proposta);
            }catch (FeignException e){
                System.out.println("Erro ao salvar cartao!");
            }
        }
    }
}
