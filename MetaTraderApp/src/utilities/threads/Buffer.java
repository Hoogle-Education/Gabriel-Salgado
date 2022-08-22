package utilities.threads;

public class Buffer {
	
	private int QUANTIDADE_DE_CAIXAS;
	private Object[] buffer;
	
	Semaforo isFull;
	Semaforo isEmpty;
	Semaforo useQueue;
	
	Integer free;
	int pos = 0;
	
	public Buffer(int quantidade) {
		
		QUANTIDADE_DE_CAIXAS = quantidade;
		
		isFull 			= new Semaforo(0);
		isEmpty 		= new Semaforo(QUANTIDADE_DE_CAIXAS);
		useQueue 		= new Semaforo(1);
		
		free = 0;
	}
	
	public void iniciar(Object operacao) {
		isEmpty.adquirir();
		useQueue.adquirir();
		
		buffer[free] = operacao;
		
		useQueue.remover();
		isFull.remover();
	}
	
	public Object terminar() {
		isFull.adquirir();
		useQueue.adquirir();
		
		Object item = buffer[pos];
		free = pos;
		
		useQueue.remover();
		isEmpty.remover();
		
		return item;
	}
	
	
	
}
