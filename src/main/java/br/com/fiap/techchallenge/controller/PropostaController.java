package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.PropostaDTO;
import br.com.fiap.techchallenge.service.PropostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    private final PropostaService propostaService;

    @Autowired
    public PropostaController(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    @PostMapping
    public ResponseEntity<PropostaDTO> save(@Valid @RequestBody PropostaDTO propostaDTO) {

        var savedProposta = propostaService.save(propostaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProposta);

    }

    @GetMapping
    public ResponseEntity<Collection<PropostaDTO>> findAll() {

        var propostas = propostaService.findAll();
        return ResponseEntity.ok(propostas);

    }

    @GetMapping("/{idProposta}")
    public ResponseEntity<PropostaDTO> findById(@PathVariable Long idProposta) {

        var propostaDTO = propostaService.findById(idProposta);
        return ResponseEntity.ok(propostaDTO);

    }

    @PutMapping("/{idProposta}")
    public ResponseEntity<PropostaDTO> update(@PathVariable Long idProposta,
                                              @Valid @RequestBody PropostaDTO propostaDTO) {

        var updatedProposta = propostaService.update(idProposta, propostaDTO);
        return ResponseEntity.ok(updatedProposta);

    }

    @DeleteMapping("/{idProposta}")
    public ResponseEntity<PropostaDTO> delete(@PathVariable Long idProposta) {

        propostaService.delete(idProposta);
        return ResponseEntity.noContent().build();

    }

    //@PutMapping("/{idProposta}")
    //public ResponseEntity<PropostaDTO> addProduto(@PathVariable Long idProposta,
    //                                              @Valid @RequestBody ProdutoDTO produtoDTO) {

    //    var updatedProposta = propostaService.addProduto(idProposta, produtoDTO);
    //    return ResponseEntity.ok(updatedProposta);

    //}

}
