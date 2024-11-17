package com.chimionato.cadastrocliente.infra;

import com.chimionato.cadastrocliente.application.repository.ClienteRepository;
import com.chimionato.cadastrocliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente postCliente(Cliente cliente) {
        log.info("[inicia  ] # ClienteInfraRepository - postCliente");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] # ClienteInfraRepository - postCliente");
        return cliente;
    }

    @Override
    public List<Cliente> getTodosClientes() {
        log.info("[inicia  ] $ ClienteInfraRepository - getTodosClientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] $ ClienteInfraRepository - getTodosClientes");
        return todosClientes;
    }
}
