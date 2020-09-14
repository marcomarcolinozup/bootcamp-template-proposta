package br.com.zup.bootcamp.proposta.controller;

import br.com.zup.bootcamp.proposta.business.PropostaBusiness;
import br.com.zup.bootcamp.proposta.dto.PropostaDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaBusiness propostaBusiness;

    @PostMapping
    public ResponseEntity<PropostaDTO> createProposta(@RequestBody PropostaDTO proposta){
        return new ResponseEntity<PropostaDTO>(propostaBusiness.createProposta(proposta), HttpStatus.CREATED);
    }

}
