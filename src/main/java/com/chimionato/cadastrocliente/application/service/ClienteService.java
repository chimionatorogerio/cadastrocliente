package com.chimionato.cadastrocliente.application.service;

import com.chimionato.cadastrocliente.application.api.ClienteDetalhadoResponse;
import com.chimionato.cadastrocliente.application.api.ClienteListResponse;
import com.chimionato.cadastrocliente.application.api.ClienteRequest;
import com.chimionato.cadastrocliente.application.api.ClienteResponse;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse postCliente(ClienteRequest clienteRequest);
    List<ClienteListResponse> getTodosClientes();
    ClienteDetalhadoResponse getUmClientePeloId(UUID idCliente);
}