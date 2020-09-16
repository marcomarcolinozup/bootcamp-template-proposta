package br.com.zup.bootcamp.proposta.dto;

import br.com.zup.bootcamp.proposta.model.STATUS_PROPOSTA;

public enum STATUS_ANALISE {

    COM_RESTRICAO(STATUS_PROPOSTA.NAO_ELEGIVEL), SEM_RESTRICAO(STATUS_PROPOSTA.ELEGIVEL)  ;

    private STATUS_PROPOSTA status;

    STATUS_ANALISE(STATUS_PROPOSTA status){
        this.status = status;
    }

    public STATUS_PROPOSTA getStatus() {
        return status;
    }
}
