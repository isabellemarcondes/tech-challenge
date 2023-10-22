package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> { }
