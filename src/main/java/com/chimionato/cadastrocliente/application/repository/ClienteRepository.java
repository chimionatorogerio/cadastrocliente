package com.chimionato.cadastrocliente.application.repository;

import com.chimionato.cadastrocliente.domain.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {
    Cliente postCliente(Cliente cliente);
    List<Cliente> getTodosClientes();
    Cliente getUmClientePeloId(UUID idCliente);
}
