package com.gabriel.biscoitos.queue;

import java.util.ArrayList;
import java.util.List;

import com.gabriel.biscoitos.model.Biscoito;

public abstract class FilaDeProducao implements Runnable {
	
	protected List<Biscoito> filaDeBiscoitos;
	
	public FilaDeProducao() {
		filaDeBiscoitos = new ArrayList<>();
	}
	
	public List<Biscoito> getFilaDeBiscoito() {
		return filaDeBiscoitos;
	}
	
	public void adicionarBiscoito(Biscoito biscoito) {
		filaDeBiscoitos.add(biscoito);
	}
	
	public Integer getTamanhoDaFila() {
		return filaDeBiscoitos.size();
	}
	
	public Integer getTempoTotalDaFila() {
		return filaDeBiscoitos
				.stream()
				.map(Biscoito::getTempoDePreparo)
				.reduce(0, Integer::sum);
	}
	
	public Biscoito pegarProximoBiscoito() {
		Biscoito proximoBiscoito = filaDeBiscoitos.get(0);
		filaDeBiscoitos.remove(0);
		return proximoBiscoito;
	}


	public static FilaDeProducao encontraMaior(FilaDeProducao fila1, FilaDeProducao fila2) {
		return fila1.getTempoTotalDaFila() > fila2.getTempoTotalDaFila()
				? fila1 : fila2;
	}
}
