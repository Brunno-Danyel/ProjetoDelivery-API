package com.brunnodanyel.com.model;

import java.time.OffsetDateTime;

public class OcorrenciaModelDto {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRgistro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OffsetDateTime getDataRgistro() {
		return dataRgistro;
	}

	public void setDataRgistro(OffsetDateTime dataRgistro) {
		this.dataRgistro = dataRgistro;
	}

}
