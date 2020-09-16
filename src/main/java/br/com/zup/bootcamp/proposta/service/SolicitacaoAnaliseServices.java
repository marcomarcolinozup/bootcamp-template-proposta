package br.com.zup.bootcamp.proposta.service;

import br.com.zup.bootcamp.proposta.config.AnaliseConfig;
import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9999/api", name = "serviceAnalise", configuration = AnaliseConfig.class)
public interface SolicitacaoAnaliseServices {

    @PostMapping("/solicitacao")
    SolicitacaoAnaliseDTO create(@RequestBody SolicitacaoAnaliseDTO solicitacao);

}
