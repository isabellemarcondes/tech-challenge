package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.dto.request.SimulacaoRequestDTO;
import br.com.fiap.techchallenge.dto.response.SimulacaoResponseDTO;
import br.com.fiap.techchallenge.service.SimulacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/simulacoes")
public class SimulacaoController {

    private final SimulacaoService simulacaoService;

    @Autowired
    public SimulacaoController(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @PostMapping
    public ResponseEntity<SimulacaoResponseDTO> save(@Valid @RequestBody SimulacaoRequestDTO simulacaoRequestDTO) {

        var savedSimulacao = simulacaoService.save(simulacaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSimulacao);

    }

    @GetMapping
    public ResponseEntity<Collection<SimulacaoResponseDTO>> findAll() {

        var simulacoes = simulacaoService.findAll();
        return ResponseEntity.ok(simulacoes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<SimulacaoResponseDTO> findById(@PathVariable(value = "id") Long idSimulacao) {

        var simulacao = simulacaoService.findById(idSimulacao);
        return ResponseEntity.ok(simulacao);

    }

    @GetMapping("/clientes")
    public ResponseEntity<Collection<SimulacaoResponseDTO>> findByCliente(@RequestParam String agencia,
                                                              @RequestParam String conta,
                                                              @RequestParam String digito) {

        var simulacoes = simulacaoService.findByCliente(agencia, conta, digito);
        return ResponseEntity.ok(simulacoes);

    }

    @PutMapping("/{id}")
    public ResponseEntity<SimulacaoResponseDTO> update(@PathVariable(value = "id") Long idSimulacao,
                                                       @Valid @RequestBody SimulacaoRequestDTO simulacaoRequestDTO) {

        var updatedSimulacao = simulacaoService.update(idSimulacao, simulacaoRequestDTO);
        return ResponseEntity.ok(updatedSimulacao);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SimulacaoResponseDTO> delete(@PathVariable(value = "id") Long idSimulacao) {

        simulacaoService.delete(idSimulacao);
        return ResponseEntity.noContent().build();

    }

}
