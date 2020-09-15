package br.com.zup.bootcamp.proposta.dto;

public class SolicitacaoAnaliseDTO {

    private String documento;
    private String nome;
    private String idProposta;
    private STATUS_SOLICITACAO statusSolicitacao;

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

    public STATUS_SOLICITACAO getStatusSolicitacao() {
        return statusSolicitacao;
    }

    public void setStatusSolicitacao(STATUS_SOLICITACAO statusSolicitacao) {
        this.statusSolicitacao = statusSolicitacao;
    }

    @Override
    public String toString() {
        return "SolicitacaoAnaliseDTO{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", idProposta='" + idProposta + '\'' +
                ", statusSolicitacao=" + statusSolicitacao +
                '}';
    }
}
