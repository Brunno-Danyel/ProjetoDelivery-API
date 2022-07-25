package com.brunnodanyel.com.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunnodanyel.com.domain.exception.EntidadeNaoEncontradaException;
import com.brunnodanyel.com.domain.model.Entrega;
import com.brunnodanyel.com.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository; 
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encotrada"));
		
	}
}
