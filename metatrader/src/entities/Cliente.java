package entities;

import java.util.List;

public class Cliente extends Thread {

	private double saldo;
	private double limite;
	
	List<Operacao> operacoes;

	public Cliente() {
	}
	
	public Cliente(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public void run() {
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
		
	}

}
