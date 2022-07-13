package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cotacao {
	
	private Date data;
	private Moeda moeda1;
	private Moeda moeda2;
	private Integer numero;
	private Integer numero2;
	
	public Cotacao(Date data, Moeda moeda1, Moeda moeda2, Integer numero, Integer numero2) {
		this.data = data;
		this.moeda1 = moeda1;
		this.moeda2 = moeda2;
		this.numero = numero;
		this.numero2 = numero2;
	}

	public Date getData() {
		return data;
	}

	public Moeda getMoeda1() {
		return moeda1;
	}

	public Moeda getMoeda2() {
		return moeda2;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getNumero2() {
		return numero2;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		return "Cotacao[data=" + formatador.format(data) + ", " + moeda1 + ", " + moeda2 + ", " + numero
				+ ", " + numero2 + "]";
	}
	
	
	
}
