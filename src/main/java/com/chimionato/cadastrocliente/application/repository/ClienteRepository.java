package com.chimionato.cadastrocliente.application.repository;

import com.chimionato.cadastrocliente.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente postCliente(Cliente cliente);
    List<Cliente> getTodosClientes();
}
