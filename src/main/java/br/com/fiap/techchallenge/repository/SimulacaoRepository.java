package br.com.fiap.techchallenge.repository;

import br.com.fiap.techchallenge.entities.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {

    List<Simulacao> findByCliente_AgenciaAndCliente_ContaAndCliente_Digito(String agencia, String conta, String digito);

}
