package com.brunnodanyel.com.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brunnodanyel.com.domain.model.Entrega;
import com.brunnodanyel.com.model.EntregaModelDto;
import com.brunnodanyel.com.model.input.EntregaInput;

@Component
public class EntregaAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public EntregaModelDto toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModelDto.class);
	}

	public List<EntregaModelDto> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}

}
