package utilities;

import java.util.ArrayList;
import java.util.List;

import entities.Cotacao;
import entities.Moeda;
import utilities.enums.Tipo;

public class CalculadoraCotacoes {

	List<Cotacao> cotacoes;

	public CalculadoraCotacoes(List<Cotacao> cotacoes) {
		this.cotacoes = cotacoes;
	}

	public List<Double> mediaMovelAritmeticaMoeda(int dias, int codigoMoeda, Tipo tipo) {
				
		List<Double> medias = new ArrayList<>();
		Moeda moeda;	
		
		for(int i = 0; i < cotacoes.size() - dias; i++) {
			double media = 0.0;
						
			if(codigoMoeda == 1) 
				moeda = cotacoes.get(i).getMoeda1();
			else 
				moeda = cotacoes.get(i).getMoeda2();
						
			for(int j = i; j < (i+5); j++) {
				if(tipo == Tipo.COMPRA) 
					media += moeda.getPrecoCompra();
				else
					media += moeda.getPrecoVenda();
			}			
		
			medias.add(media /= dias);
		}
		
		return medias;  
	}

	public String mediaMovelAritmetica(int dias) {
		String aux = "";
		aux += mediaMovelAritmeticaMoeda(dias, 1, Tipo.COMPRA);
		aux += "\n";
		aux += mediaMovelAritmeticaMoeda(dias, 2, Tipo.VENDA);
		return aux;
	}
	
	public List<Double> mediaMovelExponencial(int dias, int codigoMoeda, Tipo tipo) {
		
		List<Double> medias = new ArrayList<>();
		double multiplicador = 2.0/(dias + 1);
		medias.add(mediaMovelAritmeticaMoeda(dias, codigoMoeda, tipo).get(0));
				
		for(int i = 1; i < (cotacoes.size()-dias); i++ ) {
			Moeda moeda = (codigoMoeda == 1) ?
						  cotacoes.get(i).getMoeda1() : 
					      cotacoes.get(i).getMoeda2();
			
			double valor = (tipo == Tipo.COMPRA) ?
							moeda.getPrecoCompra() :
							moeda.getPrecoVenda();
			
			medias.add(multiplicador*(valor - medias.get(i-1)) + medias.get(i-1));
		}
		
		return medias;
	}
}
