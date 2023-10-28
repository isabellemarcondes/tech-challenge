package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.ClienteDTO;
import br.com.fiap.techchallenge.dto.request.SimulacaoRequestDTO;
import br.com.fiap.techchallenge.dto.response.SimulacaoResponseDTO;
import br.com.fiap.techchallenge.entities.Cliente;
import br.com.fiap.techchallenge.entities.PerfilInvestidor;
import br.com.fiap.techchallenge.entities.Simulacao;

public class SimulacaoMapper {

    public static Simulacao toEntity(SimulacaoRequestDTO simulacaoRequestDTO) {

        Cliente cliente = Cliente.builder()
                .agencia(simulacaoRequestDTO.cliente().agencia())
                .conta(simulacaoRequestDTO.cliente().conta())
                .digito(simulacaoRequestDTO.cliente().digito())
                .build();

        return Simulacao.builder()
                .idSimulacao(null)
                .descricaoSimulacao(simulacaoRequestDTO.descricaoSimulacao())
                .perfilInvestidor(PerfilInvestidor.fromId(simulacaoRequestDTO.idPerfilInvestidor()))
                .cliente(cliente)
                .build();

    }

    public static SimulacaoResponseDTO toResponseDTO(Simulacao simulacao) {

        return new SimulacaoResponseDTO(
                simulacao.getIdSimulacao(),
                simulacao.getDescricaoSimulacao(),
                simulacao.getPerfilInvestidor(),
                new ClienteDTO(simulacao.getCliente().getAgencia(),
                        simulacao.getCliente().getConta(),
                        simulacao.getCliente().getDigito()),
                simulacao.getDataGeracaoSimulacao()
        );
    }
}
