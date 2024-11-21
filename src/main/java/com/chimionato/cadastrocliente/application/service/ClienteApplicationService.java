package com.chimionato.cadastrocliente.application.service;

import com.chimionato.cadastrocliente.application.api.*;
import com.chimionato.cadastrocliente.application.repository.ClienteRepository;
import com.chimionato.cadastrocliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public ClienteDetalhadoResponse getUmClientePeloId(UUID idCliente) {
        log.info("[inicia  ] % ClienteApplicationService - getUmClientePeloId");
        Cliente cliente = clienteRepository.getUmClientePeloId(idCliente);
        log.info("[finaliza] % ClienteApplicationService - getUmClientePeloId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void deletaUmClientePeloId(UUID idCliente) {
        log.info("[inicia  ] Z ClienteApplicationService - deletaClienteAtravesId");
        Cliente cliente = clienteRepository.getUmClientePeloId(idCliente);
        clienteRepository.deletaCliente(cliente);
        log.info("[finaliza] Z ClienteApplicationService - deletaClienteAtravesId");
    }

    @Override
    public void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[inicia] ClienteApplicationService - patchAlteraCliente");
        Cliente cliente = clienteRepository.getUmClientePeloId(idCliente);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.postCliente(cliente);
        log.info("[finaliza] ClienteApplicationService - patchAlteraCliente");
    }
}