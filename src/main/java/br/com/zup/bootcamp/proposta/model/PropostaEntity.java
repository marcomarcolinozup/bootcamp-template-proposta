package br.com.zup.bootcamp.proposta.model;

import br.com.zup.bootcamp.proposta.validator.ValidaCPForCNPJ;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Entity
@Table(name = "proposta" )
public class PropostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ValidaCPForCNPJ
    private String documento;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$")
    private String email;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String endereco;

    @NotNull
    @Min(0)
    private BigDecimal salario;

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
}
