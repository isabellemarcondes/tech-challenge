package br.com.fiap.techchallenge.dto;

import br.com.fiap.techchallenge.entities.Produto;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record PropostaDTO(
        Long idProposta,

        @NotBlank(message = "Descrição não pode estar em branco")
        String descricaoProposta,

        LocalDate dataGeracaoProposta,

        List<Produto> produtos) {
}
