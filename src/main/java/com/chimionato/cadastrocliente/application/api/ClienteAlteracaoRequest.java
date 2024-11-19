package com.chimionato.cadastrocliente.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ClienteAlteracaoRequest {
    @NotBlank
    private String nomeCompleto;
}