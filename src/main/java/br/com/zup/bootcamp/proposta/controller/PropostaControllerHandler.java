package br.com.zup.bootcamp.proposta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class PropostaControllerHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleDogsServiceException(ConstraintViolationException e){
        return error(HttpStatus.BAD_REQUEST, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }

}
