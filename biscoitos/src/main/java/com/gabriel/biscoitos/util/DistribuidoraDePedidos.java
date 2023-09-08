package com.gabriel.biscoitos.util;

import com.gabriel.biscoitos.model.Biscoito;
import com.gabriel.biscoitos.model.Forno;
import com.gabriel.biscoitos.queue.FilaDeProducao;
import com.gabriel.biscoitos.queue.FilaDeProducaoBiscoitoComum;
import com.gabriel.biscoitos.queue.FilaDeProducaoDeRecheados;

public class DistribuidoraDePedidos implements Runnable {
	
	private static FilaDeProducao filaA;
	private static FilaDeProducao filaB;
	private static FilaDeProducao filaC;

	private static Forno forno1;
	private static Forno forno2;
	
	public static void produzir(Biscoito biscoito) {
		filaA = new FilaDeProducaoDeRecheados();
		filaB = new FilaDeProducaoDeRecheados();
		filaC = new FilaDeProducaoBiscoitoComum();
	}


	@Override
	public void run() {
		while ( true ){
			if (forno1.estaVazio()) {
				FilaDeProducao maiorFila = FilaDeProducao.encontraMaior(filaA, filaB);
				forno1.adicionarBiscoito(maiorFila.pegarProximoBiscoito());
				forno1.prepararBiscoito();
			}

			if (forno2.estaVazio()) {
				FilaDeProducao maiorFila = FilaDeProducao.encontraMaior(filaB, filaC);
				forno2.adicionarBiscoito(maiorFila.pegarProximoBiscoito());
				forno2.prepararBiscoito();
			}
		}
	}
}
