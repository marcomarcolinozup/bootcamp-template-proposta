package br.com.zup.bootcamp.proposta.controller;

import br.com.zup.bootcamp.proposta.exception.PropostaDuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class PropostaControllerHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidateContraintException(ConstraintViolationException e){
        List<String> erros =
        e.getConstraintViolations()
                .stream().map(violation -> String.format("Erro de validacao %s %s valor enviado '%s' ",
                                                            violation.getPropertyPath() ,
                                                            violation.getMessage(),
                                                            violation.getInvalidValue()))
                .collect(Collectors.toList());
        return error(HttpStatus.BAD_REQUEST, erros.toArray(String[]::new));
    }

    @ExceptionHandler(PropostaDuplicateException.class)
    public ResponseEntity<String> handlePropostaDuplicateErrorServiceException(PropostaDuplicateException e){
        return error(HttpStatus.UNPROCESSABLE_ENTITY, new String[]{"Documento duplicado"});
    }

    private ResponseEntity<String> error(HttpStatus status, String[] erros) {
        return ResponseEntity.status(status).body(Arrays.toString(erros));
    }

}
