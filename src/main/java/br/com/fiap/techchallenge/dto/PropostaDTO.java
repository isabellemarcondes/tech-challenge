package br.com.fiap.techchallenge.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PropostaDTO(
        Long idProposta,

        @NotBlank(message = "Descrição não pode estar em branco")
        String descricaoProposta,

        LocalDate dataGeracaoProposta) {
}
