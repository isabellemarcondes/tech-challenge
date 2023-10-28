package br.com.fiap.techchallenge.dto.request;

import br.com.fiap.techchallenge.dto.ClienteDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SimulacaoRequestDTO(
        @NotBlank(message = "Descrição não pode ser vazia")
        String descricaoSimulacao,

        @NotNull(message = "Perfil de investidor não deve ser nulo")
        int idPerfilInvestidor,

        ClienteDTO cliente) {
}
