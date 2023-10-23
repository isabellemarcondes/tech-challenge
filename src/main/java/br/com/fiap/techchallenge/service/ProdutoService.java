package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.controller.exception.ControllerNotFoundException;
import br.com.fiap.techchallenge.dto.ProdutoDTO;
import br.com.fiap.techchallenge.entities.Produto;
import br.com.fiap.techchallenge.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Collection<ProdutoDTO> findAll() {

        return produtoRepository
                .findAll()
                .stream()
                .map(this::toProdutoDTO)
                .collect(Collectors.toList());

    }

    public ProdutoDTO findById(Long idProposta) {

        return toProdutoDTO(produtoRepository
                .findById(idProposta)
                .orElseThrow(
                        () -> new ControllerNotFoundException("Produto não encontrado"))
        );

    }

    private ProdutoDTO toProdutoDTO(Produto produto) {

        return new ProdutoDTO(
                produto.getIdProduto(),
                produto.getCodigoProduto()
        );

    }

    private Produto toProduto(ProdutoDTO produtoDTO) {

        return new Produto(
                produtoDTO.idProduto(),
                produtoDTO.codigoProduto()
        );

    }

}
