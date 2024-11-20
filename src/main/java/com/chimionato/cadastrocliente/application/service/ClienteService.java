package com.chimionato.cadastrocliente.application.service;

import com.chimionato.cadastrocliente.application.api.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse postCliente(ClienteRequest clienteRequest);
    List<ClienteListResponse> getTodosClientes();
    ClienteDetalhadoResponse getUmClientePeloId(UUID idCliente);
    void deletaUmClientePeloId(UUID idCliente);
    void patchAlteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);
}