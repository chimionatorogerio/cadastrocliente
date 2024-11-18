package com.chimionato.cadastrocliente.infra;

import com.chimionato.cadastrocliente.application.repository.ClienteRepository;
import com.chimionato.cadastrocliente.domain.Cliente;
import com.chimionato.cadastrocliente.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Cliente getUmClientePeloId(UUID idCliente) {
        log.info("[inicia  ] * ClienteInfraRepository - getUmClientePeloId");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
        log.info("[finaliza] * ClienteInfraRepository - getUmClientePeloId");
        return cliente;
    }
}