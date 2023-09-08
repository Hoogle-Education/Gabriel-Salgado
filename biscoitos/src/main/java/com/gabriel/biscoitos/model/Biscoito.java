package com.gabriel.biscoitos.model;

import com.gabriel.biscoitos.model.enums.Categoria;

public class Biscoito {
	
	private static Long contador_id;
	private Long id;
	private Categoria categoria;
	private Integer tempoDeProcessamento;
	private Integer tempoDePreparo;
	
	public Biscoito(Categoria categoria) {
		id = contador_id++;
		this.categoria = categoria;
		this.tempoDeProcessamento = -1; // não processado
	}

	public Long getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Integer getTempoDeProcessamento() {
		return tempoDeProcessamento;
	}

	public void setTempoDeProcessamento(Integer tempoDeProcessamento) {
		this.tempoDeProcessamento = tempoDeProcessamento;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}
	
}
