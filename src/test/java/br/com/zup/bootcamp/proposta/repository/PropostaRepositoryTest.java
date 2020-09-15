package br.com.zup.bootcamp.proposta.repository;

import br.com.zup.bootcamp.proposta.model.PropostaEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PropostaRepositoryTest {

    @Autowired
    private PropostaRepository propostaRepository;

    @Test
    public void testValidateOKPropostaEntity(){
        PropostaEntity entity = new PropostaEntity(
                "39746331469",
                "email@teste.com",
                "nome",
                "endereco",
                new BigDecimal(100.00));
        entity = propostaRepository.save(entity);
        Assert.notNull(entity.getId());
    }

    @Test
    public void testValidateFailPropostaEntity(){
        Assertions.assertThrows( ConstraintViolationException.class, () -> {
            PropostaEntity entity = new PropostaEntity(
                    "97463311111",
                    "@email@teste.com",
                    null,
                    "",
                    new BigDecimal(-100.00));
            entity = propostaRepository.save(entity);
        });
    }

    @Test
    public void testValidateFailCPFPropostaEntity(){
        Assertions.assertThrows( ConstraintViolationException.class, () -> {
            PropostaEntity entity = new PropostaEntity(
                    "97463311111",
                    "email@teste.com",
                    "nome valido",
                    "enderco valido",
                    new BigDecimal(100.00));
            entity = propostaRepository.save(entity);
        });
    }

    @Test
    public void testValidateOkCPFPropostaEntity(){
        PropostaEntity entity = new PropostaEntity(
                "61987544307",
                "email@teste.com",
                "nome valido",
                "enderco valido",
                new BigDecimal(100.00));
        entity = propostaRepository.save(entity);
        Assert.notNull(entity.getId());
    }

    @Test
    public void testValidateFailCNPJPropostaEntity(){
        Assertions.assertThrows( ConstraintViolationException.class, () -> {
            PropostaEntity entity = new PropostaEntity(
                    "97463311111123",
                    "email@teste.com",
                    "nome valido",
                    "enderco valido",
                    new BigDecimal(-100.00));
            entity = propostaRepository.save(entity);
        });
    }

    @Test
    public void testValidateOkCNPJPropostaEntity(){
        PropostaEntity entity = new PropostaEntity(
                "14757196000178",
                "email@teste.com",
                "nome valido",
                "enderco valido",
                new BigDecimal(100.00));
        entity = propostaRepository.save(entity);
        Assert.notNull(entity.getId());
    }

    @Test
    public void testValidateUnicDocumentPropostaEntity(){
        Assertions.assertThrows( DataIntegrityViolationException.class, () -> {
            PropostaEntity entity = new PropostaEntity(
                    "74184736000101",
                    "email@teste.com",
                    "nome valido",
                    "enderco valido",
                    new BigDecimal(100.00));
            entity = propostaRepository.save(entity);
            PropostaEntity entity2 = new PropostaEntity(
                    "74184736000101",
                    "email2@teste.com",
                    "nome valido2",
                    "enderco valido2",
                    new BigDecimal(1000.00));
            entity2 = propostaRepository.save(entity2);
        });
    }
}
