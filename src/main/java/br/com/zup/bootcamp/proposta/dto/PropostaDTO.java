package br.com.zup.bootcamp.proposta.dto;

import br.com.zup.bootcamp.proposta.model.STATUS_PROPOSTA;

import java.math.BigDecimal;

public class PropostaDTO {

    private Integer id;
    private String documento;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;
    private STATUS_PROPOSTA status;

    public STATUS_PROPOSTA getStatus() {
        return status;
    }

    public void setStatus(STATUS_PROPOSTA status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void isValid(){

    }

}
