package br.com.zup.bootcamp.proposta.validator;

import javax.validation.Payload;

public @interface ValidaCPForCNPJ {
    String message() default "Invalid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
