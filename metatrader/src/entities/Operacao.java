package entities;

import java.util.Date;

public class Operacao {

	private Date momento;
	private Cliente cliente;
	private Ativo ativo;
	private Corretora corretora;
	
	public Operacao(Cliente cliente, Ativo ativo, Corretora corretora) {
		momento = ativo.getDate();
		ativo = this.ativo;
		corretora = this.corretora;
		corretora = this.corretora;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Corretora getCorretora() {
		return corretora;
	}

	public void setCorretora(Corretora corretora) {
		this.corretora = corretora;
	}
	
}
