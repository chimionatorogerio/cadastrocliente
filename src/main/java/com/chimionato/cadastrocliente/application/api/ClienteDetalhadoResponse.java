package com.chimionato.cadastrocliente.application.api;

import com.chimionato.cadastrocliente.domain.Cliente;

import java.util.UUID;

public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String email;
    private String CPF;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.email = cliente.getEmail();
    }
}
