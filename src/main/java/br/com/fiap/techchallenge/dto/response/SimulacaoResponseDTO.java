package br.com.fiap.techchallenge.dto.response;

import br.com.fiap.techchallenge.dto.ClienteDTO;
import br.com.fiap.techchallenge.dto.ProdutoDTO;
import br.com.fiap.techchallenge.entities.PerfilInvestidor;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SimulacaoResponseDTO(Long idProposta,
                                   String descricaoSimulacao,
                                   PerfilInvestidor perfilInvestidor,
                                   ClienteDTO cliente,
                                   List<ProdutoDTO> produtos,
                                   LocalDate dataGeracaoSimulacao) {
}
