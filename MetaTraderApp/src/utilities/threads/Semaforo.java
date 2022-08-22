package utilities.threads;

public class Semaforo {
	
	private int size;
	
	public Semaforo(int size) {
		this.size = size;
	}
	
	public synchronized void adquirir() {
		while(size == 0) {
		
			try { wait(); }
			catch (InterruptedException excep) {}
		}
		
		size--;
	}
	
	public synchronized void remover() {
		size++;
		notify();
	}
	
}
