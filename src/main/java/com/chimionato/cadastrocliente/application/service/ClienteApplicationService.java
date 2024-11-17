package com.chimionato.cadastrocliente.application.service;

import com.chimionato.cadastrocliente.application.api.ClienteListResponse;
import com.chimionato.cadastrocliente.application.api.ClienteRequest;
import com.chimionato.cadastrocliente.application.api.ClienteResponse;
import com.chimionato.cadastrocliente.application.repository.ClienteRepository;
import com.chimionato.cadastrocliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia  ] @ ClienteApplicationService - postCliente");
        Cliente cliente = clienteRepository.postCliente(new Cliente(clienteRequest));
        log.info("[finaliza] @ ClienteApplicationService - postCliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    @Override
    public List<ClienteListResponse> getTodosClientes() {
        log.info("[inicia  ] & ClienteApplicationService - getTodosClientes");
        List<Cliente> clientes = clienteRepository.getTodosClientes();
        log.info("[finaliza] & ClienteApplicationService - getTodosClientes");
        return ClienteListResponse.converte(clientes);
    }
}
