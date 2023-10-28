package br.com.fiap.techchallenge.dto.response;

import br.com.fiap.techchallenge.dto.ClienteDTO;
import br.com.fiap.techchallenge.entities.PerfilInvestidor;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SimulacaoResponseDTO(Long idProposta,
                                   String descricaoSimulacao,
                                   PerfilInvestidor perfilInvestidor,
                                   ClienteDTO cliente,
                                   LocalDate dataGeracaoSimulacao) {
}
