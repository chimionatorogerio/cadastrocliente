package com.chimionato.cadastrocliente.application.service;

import com.chimionato.cadastrocliente.application.api.ClienteRequest;
import com.chimionato.cadastrocliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse postCliente(ClienteRequest clienteRequest);
}
