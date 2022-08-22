package entities;

import java.util.Date;

import utilities.threads.Buffer;

public class Operacao implements Runnable {
	
	private Buffer buffer;
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
	
	public Operacao(Buffer buffer, Operacao copy) {
		this.buffer = buffer;
		this.ativo = copy.ativo;
		this.momento = copy.momento;
		this.cliente = copy.cliente;
		this.corretora = copy.corretora;
	}
	
	@Override
	public void run() {
			
			buffer.iniciar(this);
			
			String aux = "Escrita com sucesso no bufffer!\n";
			aux += "operacao: " + this.toString() + "\n";
			aux += "---------------------------------\n";
			
			System.out.println(aux);
		
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

	public Operacao(Date momento, Cliente cliente, Ativo ativo, Corretora corretora) {
		this.momento = momento;
		this.cliente = cliente;
		this.ativo = ativo;
		this.corretora = corretora;
	}
	
}
