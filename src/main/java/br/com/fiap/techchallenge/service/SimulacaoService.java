package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.controller.exception.ControllerNotFoundException;
import br.com.fiap.techchallenge.dto.ClienteDTO;
import br.com.fiap.techchallenge.dto.ProdutoDTO;
import br.com.fiap.techchallenge.dto.request.SimulacaoRequestDTO;
import br.com.fiap.techchallenge.dto.response.SimulacaoResponseDTO;
import br.com.fiap.techchallenge.entities.PerfilInvestidor;
import br.com.fiap.techchallenge.entities.Produto;
import br.com.fiap.techchallenge.mapper.ClienteMapper;
import br.com.fiap.techchallenge.mapper.SimulacaoMapper;
import br.com.fiap.techchallenge.repository.SimulacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import static br.com.fiap.techchallenge.mapper.ClienteMapper.toEntity;
import static br.com.fiap.techchallenge.mapper.SimulacaoMapper.toEntity;
import static br.com.fiap.techchallenge.mapper.SimulacaoMapper.toResponseDTO;

@Service
public class SimulacaoService {

    private final SimulacaoRepository simulacaoRepository;

    @Autowired
    public SimulacaoService(SimulacaoRepository simulacaoRepository) {

        this.simulacaoRepository = simulacaoRepository;

    }

    public SimulacaoResponseDTO save(SimulacaoRequestDTO simulacaoRequestDTO) {

        var simulacao = toEntity(simulacaoRequestDTO);

        return toResponseDTO(simulacaoRepository.save(simulacao));

    }

    public Collection<SimulacaoResponseDTO> findAll() {

        return simulacaoRepository
                .findAll()
                .stream()
                .map(SimulacaoMapper::toResponseDTO)
                .collect(Collectors.toList());

    }

    public SimulacaoResponseDTO findById(Long idSimulacao) {

        return toResponseDTO(simulacaoRepository
                .findById(idSimulacao)
                .orElseThrow(
                        () -> new ControllerNotFoundException("Simulação não encontrada"))
        );

    }

    public Collection<SimulacaoResponseDTO> findByCliente(String agencia, String conta, String digito) {

        return simulacaoRepository
                .findByCliente_AgenciaAndCliente_ContaAndCliente_Digito(agencia, conta, digito)
                .stream()
                .map(SimulacaoMapper::toResponseDTO)
                .collect(Collectors.toList());

    }

    public SimulacaoResponseDTO update(Long idSimulacao, SimulacaoRequestDTO simulacaoRequestDTO) {

        try {
            var simulacao = simulacaoRepository.getReferenceById(idSimulacao);
            simulacao.setDescricaoSimulacao(simulacaoRequestDTO.descricaoSimulacao());
            simulacao.setPerfilInvestidor(PerfilInvestidor.fromId(simulacaoRequestDTO.idPerfilInvestidor()));
            simulacao.setCliente(toEntity(simulacaoRequestDTO.cliente()));
            return toResponseDTO(simulacaoRepository.save(simulacao));
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Simulação não encontrada");
        }

    }

    public void delete(Long idSimulacao) {

        simulacaoRepository.findById(idSimulacao)
                .orElseThrow(
                        () -> new ControllerNotFoundException("Simulação não encontrada")
                );

        simulacaoRepository.deleteById(idSimulacao);

    }

    public SimulacaoResponseDTO addProduto(Long idSimulacao, ProdutoDTO produtoDTO) {

        var simulacao = simulacaoRepository.getReferenceById(idSimulacao);

        Produto produto = new Produto();
        produto.setNomeProduto(produto.getNomeProduto());
        produto.setNomeInstituicao(produto.getNomeInstituicao());

        if (simulacao.getProdutos() == null) {
            simulacao.setProdutos(new HashSet<>());
        }

        simulacao.getProdutos().add(produto);

        return toResponseDTO(simulacaoRepository.save(simulacao));

    }

}
