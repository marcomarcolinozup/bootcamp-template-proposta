package br.com.zup.bootcamp.proposta.business;

import br.com.zup.bootcamp.proposta.dto.PropostaDTO;
import br.com.zup.bootcamp.proposta.dto.STATUS_SOLICITACAO;
import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseDTO;
import br.com.zup.bootcamp.proposta.exception.SolicitacaoAnaliseException;
import br.com.zup.bootcamp.proposta.service.SolicitacaoAnaliseServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnalisePropostaBusiness {

    @Autowired
    private SolicitacaoAnaliseServices analiseServices;


    public void analiseProposta(PropostaDTO proposta){
        SolicitacaoAnaliseDTO solicitacaoAnalise = propostaToSolicitacao(proposta);
        solicitacaoAnalise = analiseServices.analiseProposta(solicitacaoAnalise);
        System.out.println(solicitacaoAnalise);
        switch (solicitacaoAnalise.getStatusSolicitacao()){
            case COM_RESTRICAO:
            case SEM_RESTRICAO:
            default:
                throw new SolicitacaoAnaliseException("Status invalido");
        }
    }

    private SolicitacaoAnaliseDTO propostaToSolicitacao(PropostaDTO proposta){
        SolicitacaoAnaliseDTO solicitacao = new SolicitacaoAnaliseDTO();
        BeanUtils.copyProperties(proposta,solicitacao);
        return solicitacao;
    }

}
