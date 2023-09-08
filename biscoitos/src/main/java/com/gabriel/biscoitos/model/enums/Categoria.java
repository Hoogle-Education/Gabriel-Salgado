package com.gabriel.biscoitos.model.enums;

public enum Categoria {
	
	COMUM("Biscoito Comum"),
	RECHEADO("Biscoito Recheado");
	
	private String value;
	
	private Categoria(String value) {
		this.value = value;
	}
	
}
