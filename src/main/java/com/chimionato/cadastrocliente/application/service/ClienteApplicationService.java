package com.chimionato.cadastrocliente.application.service;

import com.chimionato.cadastrocliente.application.api.ClienteRequest;
import com.chimionato.cadastrocliente.application.api.ClienteResponse;
import com.chimionato.cadastrocliente.domain.Cliente;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {
    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia  ] @ ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finaliza] @ ClienteApplicationService - criaCliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }
}
