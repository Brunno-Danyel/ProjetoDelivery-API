package com.brunnodanyel.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunnodanyel.com.assembler.OcorrenciaAssembler;
import com.brunnodanyel.com.domain.model.Entrega;
import com.brunnodanyel.com.domain.model.Ocorrencia;
import com.brunnodanyel.com.domain.service.BuscaEntregaService;
import com.brunnodanyel.com.domain.service.RegistroOcorrenciaService;
import com.brunnodanyel.com.model.OcorrenciaModelDto;
import com.brunnodanyel.com.model.input.OcorrenciaInput;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;

	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;

	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModelDto registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,
				ocorrenciaInput.getDescricao());

		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}

	@GetMapping()
	public List<OcorrenciaModelDto> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollentionModel(entrega.getOcorrencias());
	}

}
