package com.chimionato.cadastrocliente.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia  ] x ClienteController - postCliente");
        ClienteResponse clienteCriado = clienteService.postCliente(clienteRequest);
        log.info("[finaliza] x ClienteController - postCliente");
        return clienteCriado;
    }
}