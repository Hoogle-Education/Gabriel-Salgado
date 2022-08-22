package entities;

import java.util.List;
import java.util.Vector;

import utilities.threads.Buffer;

public class Corretora implements Runnable {

	private Buffer buffer;
	private Ativo A, B, C, D;
	
	// thread safety
	private List<Integer> contagemOperacoes = new Vector<>();
	
	public Corretora(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		
		while(totalDeOperacoes() <= 1000) {
			
			String item = buffer.terminar().toString();
			
			try {
				System.out.println("[PROCESSANDO]" + item);
				Thread.sleep(500); 
				System.out.println("[FINALIZADO] " + item);
			} catch (InterruptedException e) { }
			
		}		
		
	}
	
	private int totalDeOperacoes() {
		int total = 0;
		
		for(Integer quantidade : contagemOperacoes) 
			total += quantidade;
		
		return total;
	}
	
}
