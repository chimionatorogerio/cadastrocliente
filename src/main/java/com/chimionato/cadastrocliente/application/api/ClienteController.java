package com.chimionato.cadastrocliente.application.api;

import com.chimionato.cadastrocliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia  ] x ClienteController - postCliente");
        ClienteResponse clienteCriado = clienteService.postCliente(clienteRequest);
        log.info("[finaliza] x ClienteController - postCliente");
        return clienteCriado;
    }

    @Override
    public List<ClienteListResponse> getTodosClientes() {
        log.info("[inicia  ] y ClienteController - getTodosClientes");
        List<ClienteListResponse> clientes = clienteService.getTodosClientes();
        log.info("[finaliza] y ClienteController - getTodosClientes");
        return clientes;
    }

    @Override
    public ClienteDetalhadoResponse getUmClientePeloId(UUID idCliente) {
        log.info("[inicia  ] Z ClienteController - getUmClientePeloId");
        log.info("<< idCliente >> {}", idCliente);
        ClienteDetalhadoResponse clienteDetalhado = clienteService.getUmClientePeloId(idCliente);
        log.info("[finaliza] Z ClienteController - getUmClientePeloId");
        return clienteDetalhado;
    }

    @Override
    public void deletaUmClientePeloId(UUID idCliente) {
        log.info("[inicia  ] > ClienteController - deletaUmClientePeloId");
        log.info("[idCliente] {}", idCliente);
        clienteService.deletaUmClientePeloId(idCliente);
        log.info("[finaliza] > ClienteController - deletaUmClientePeloId");
    }
}