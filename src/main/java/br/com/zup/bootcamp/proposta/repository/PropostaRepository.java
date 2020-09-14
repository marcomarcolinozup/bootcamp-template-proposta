package br.com.zup.bootcamp.proposta.repository;

import br.com.zup.bootcamp.proposta.model.PropostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity,Integer> {


}
