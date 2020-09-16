package br.com.zup.bootcamp.proposta.dto;

import br.com.zup.bootcamp.proposta.model.STATUS_PROPOSTA;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolicitacaoAnaliseDTO {

    private String documento;
    private String nome;
    private String idProposta;

    private STATUS_ANALISE resultadoSolicitacao;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }

    public STATUS_ANALISE getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public void setResultadoSolicitacao(STATUS_ANALISE resultadoSolicitacao) {
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    @Override
    public String toString() {
        return "SolicitacaoAnaliseDTO{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", idProposta='" + idProposta + '\'' +
                ", resultadoSolicitacao=" + resultadoSolicitacao +
                '}';
    }
}
