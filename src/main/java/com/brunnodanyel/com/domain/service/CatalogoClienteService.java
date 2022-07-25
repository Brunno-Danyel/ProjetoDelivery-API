package com.brunnodanyel.com.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunnodanyel.com.domain.exception.NegocioException;
import com.brunnodanyel.com.domain.model.Cliente;
import com.brunnodanyel.com.domain.repository.ClienteRepository;

@Service
public class CatalogoClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new NegocioException("Cliente não encontrado"));

	}

	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
		}

		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}

}
