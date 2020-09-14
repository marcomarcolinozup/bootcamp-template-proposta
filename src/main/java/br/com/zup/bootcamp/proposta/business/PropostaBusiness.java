package br.com.zup.bootcamp.proposta.business;

import br.com.zup.bootcamp.proposta.dto.PropostaDTO;
import br.com.zup.bootcamp.proposta.model.PropostaEntity;
import br.com.zup.bootcamp.proposta.repository.PropostaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropostaBusiness {

    @Autowired
    private PropostaRepository repository;


    public PropostaDTO createProposta(PropostaDTO proposta){
        PropostaEntity entity = dtoToEntity(proposta);
        proposta = entityToDto(repository.save(entity));
        return proposta;
    }

    private PropostaEntity dtoToEntity(PropostaDTO source){
        PropostaEntity entity = new PropostaEntity();
        BeanUtils.copyProperties(source, entity);
        return entity;
    }

    private PropostaDTO entityToDto(PropostaEntity source){
        PropostaDTO target = new PropostaDTO();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}