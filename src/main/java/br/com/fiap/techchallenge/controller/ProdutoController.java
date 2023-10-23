package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.ProdutoDTO;
import br.com.fiap.techchallenge.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public ResponseEntity<Collection<ProdutoDTO>> findAll() {

        var produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);

    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long idProduto) {

        var produtoDTO = produtoService.findById(idProduto);
        return ResponseEntity.ok(produtoDTO);

    }

}
