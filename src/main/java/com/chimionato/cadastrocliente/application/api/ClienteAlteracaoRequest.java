package com.chimionato.cadastrocliente.application.api;

import jakarta.validation.constraints.NotBlank;

public class ClienteAlteracaoRequest {
    @NotBlank
    private String nomeCompleto;
}