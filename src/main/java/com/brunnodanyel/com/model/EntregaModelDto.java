package com.brunnodanyel.com.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.brunnodanyel.com.domain.model.StatusEntrega;

public class EntregaModelDto {

	private Long id;
	private ClienteResumoModel cliente;
	private DestinatarioModelDto destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteResumoModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumoModel cliente) {
		this.cliente = cliente;
	}

	public DestinatarioModelDto getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioModelDto destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
