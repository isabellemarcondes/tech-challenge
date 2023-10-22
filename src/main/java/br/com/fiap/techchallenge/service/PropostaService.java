package br.com.fiap.techchallenge.service;

import br.com.fiap.techchallenge.controller.exception.ControllerNotFoundException;
import br.com.fiap.techchallenge.dto.PropostaDTO;
import br.com.fiap.techchallenge.entities.Proposta;
import br.com.fiap.techchallenge.repository.PropostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;

    @Autowired
    public PropostaService(PropostaRepository propostaRepository) {

        this.propostaRepository = propostaRepository;

    }

    public PropostaDTO save(PropostaDTO propostaDTO) {

        var proposta = toProposta(propostaDTO);
        return toPropostaDTO(propostaRepository.save(proposta));

    }

    public Collection<PropostaDTO> findAll() {

        return propostaRepository
                .findAll()
                .stream()
                .map(this::toPropostaDTO)
                .collect(Collectors.toList());

    }

    public PropostaDTO findById(Long idProposta) {

        return toPropostaDTO(propostaRepository
                .findById(idProposta)
                .orElseThrow(
                        () -> new ControllerNotFoundException("Proposta não encontrada"))
        );

    }

    public PropostaDTO update(Long idProposta, PropostaDTO propostaDTO) {

        try {
            var proposta = propostaRepository.getReferenceById(idProposta);
            proposta.setDescricaoProposta(propostaDTO.descricaoProposta());
            return toPropostaDTO(propostaRepository.save(proposta));
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Proposta não encontrada");
        }

    }

    public void delete(Long idProposta) {

        propostaRepository.findById(idProposta)
                .orElseThrow(
                        () -> new ControllerNotFoundException("Proposta não encontrada")
                );

        propostaRepository.deleteById(idProposta);


    }

    private PropostaDTO toPropostaDTO(Proposta proposta) {

        return new PropostaDTO(
                proposta.getIdProposta(),
                proposta.getDescricaoProposta(),
                proposta.getDataGeracaoProposta(),
                proposta.getProdutos()
        );

    }

    private Proposta toProposta(PropostaDTO propostaDTO) {

        return new Proposta(
                propostaDTO.idProposta(),
                propostaDTO.descricaoProposta(),
                propostaDTO.dataGeracaoProposta(),
                propostaDTO.produtos()
        );

    }

}
