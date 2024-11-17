package com.chimionato.cadastrocliente.application.api;

import lombok.Value;

import java.util.UUID;

public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String email;
}
