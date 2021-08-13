package com.zup.propostas.annotation;

import com.zup.propostas.modelo.Proposta;
import com.zup.propostas.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ExistsSameProposalValidator implements ConstraintValidator<ExistsSameProposal, String> {
    @Autowired
    private PropostaRepository propostaRepository;

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Proposta> possivelProposta = propostaRepository.findByDocumento(documento);

        return possivelProposta.isEmpty();
    }
}
