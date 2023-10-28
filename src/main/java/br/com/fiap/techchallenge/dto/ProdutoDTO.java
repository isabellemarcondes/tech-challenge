package br.com.fiap.techchallenge.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProdutoDTO(Long idProduto,
                         String nomeProduto,
                         String nomeInstituicao) {
}
