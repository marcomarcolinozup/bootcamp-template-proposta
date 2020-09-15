package br.com.zup.bootcamp.proposta.service;

import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9999/api/solicitacao", name = "serviceAnalise")
public interface SolicitacaoAnaliseServices {

    @PostMapping()
    SolicitacaoAnaliseDTO analiseProposta(@RequestBody SolicitacaoAnaliseDTO solicitacao);

}
