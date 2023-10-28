package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.ProdutoDTO;
import br.com.fiap.techchallenge.entities.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoDTO produtoDTO) {

        return Produto.builder()
                .idProduto(null)
                .nomeProduto(produtoDTO.nomeProduto())
                .nomeInstituicao(produtoDTO.nomeInstituicao())
                .build();

    }

    public static ProdutoDTO toResponseDTO(Produto produto) {

        return new ProdutoDTO(produto.getIdProduto(),
                produto.getNomeProduto(),
                produto.getNomeInstituicao()
        );

    }
}
