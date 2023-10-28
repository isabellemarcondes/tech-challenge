package br.com.fiap.techchallenge.mapper;

import br.com.fiap.techchallenge.dto.ClienteDTO;
import br.com.fiap.techchallenge.entities.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteDTO clienteDTO) {

        return Cliente.builder()
                .agencia(clienteDTO.agencia())
                .conta(clienteDTO.conta())
                .digito(clienteDTO.digito())
                .build();
    }
}
