package entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import utilities.threads.Buffer;

public class Cliente implements Runnable {
	
	private static Random random;
	private int operacoesPendentes;
	
	private Buffer buffer;
	private double saldo;
	
	private BigDecimal limiteCompra;
	private BigDecimal limiteVenda;
	private double stopLoss;
	
	public Cliente(Buffer buffer) {
		this.buffer = buffer;
		operacoesPendentes = random.nextInt(30, 50);
	}
	
	List<Operacao> operacoes;
	
	public void run() {
		
		while(operacoesPendentes > 0) {
			
			buffer.iniciar(this);
			
			operacoesPendentes--;

			String aux = "Escrita com sucesso no bufffer!\n";
			aux += "operacao: " + this.toString() + "\n";
			aux += "---------------------------------\n";
			
			System.out.println(aux);
			
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) { }
			
		}
		
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getLimiteCompra() {
		return limiteCompra;
	}

	public void setLimiteCompra(BigDecimal limiteCompra) {
		this.limiteCompra = limiteCompra;
	}

	public BigDecimal getLimiteVenda() {
		return limiteVenda;
	}

	public void setLimiteVenda(BigDecimal limiteVenda) {
		this.limiteVenda = limiteVenda;
	}

	public double getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}

}
