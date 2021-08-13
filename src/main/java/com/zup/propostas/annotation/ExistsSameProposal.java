package com.zup.propostas.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistsSameProposalValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ExistsSameProposal {
    String message() default "Já existe uma proposta para o cpf solicitado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
