package br.com.fiap.techchallenge.dto;

import java.time.LocalDate;

public record PropostaDTO(Long idProposta,
                          String descricaoProposta,
                          LocalDate dataGeracaoProposta) {
}
