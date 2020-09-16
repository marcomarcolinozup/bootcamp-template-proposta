package br.com.zup.bootcamp.proposta.business;

import br.com.zup.bootcamp.proposta.dto.PropostaDTO;
import br.com.zup.bootcamp.proposta.dto.SolicitacaoAnaliseDTO;
import br.com.zup.bootcamp.proposta.exception.SolicitacaoAnaliseException;
import br.com.zup.bootcamp.proposta.model.STATUS_PROPOSTA;
import br.com.zup.bootcamp.proposta.service.SolicitacaoAnaliseServices;
import feign.FeignException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnalisePropostaBusiness {

    @Autowired
    private SolicitacaoAnaliseServices analiseServices;


    public STATUS_PROPOSTA analiseProposta(PropostaDTO proposta){
        SolicitacaoAnaliseDTO solicitacaoAnalise = propostaToSolicitacao(proposta);
        try {
            SolicitacaoAnaliseDTO solicitacaoAnaliseRetorno = analiseServices.create(solicitacaoAnalise);
            if(solicitacaoAnaliseRetorno.getResultadoSolicitacao() != null){
                return solicitacaoAnaliseRetorno.getResultadoSolicitacao().getStatus();
            }
        }catch(FeignException fex){
            if(fex.status() == 422 && fex.getMessage().contains("COM_RESTRICAO")){
                return STATUS_PROPOSTA.NAO_ELEGIVEL;
            }
        }
        throw new SolicitacaoAnaliseException("Erro com o retorno da analise");
    }

    private SolicitacaoAnaliseDTO propostaToSolicitacao(PropostaDTO proposta){
        SolicitacaoAnaliseDTO solicitacao = new SolicitacaoAnaliseDTO();
        BeanUtils.copyProperties(proposta,solicitacao);
        solicitacao.setIdProposta(proposta.getId().toString());
        return solicitacao;
    }

}
