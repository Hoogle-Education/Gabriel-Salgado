package utilities;

import java.util.ArrayList;
import java.util.List;

import entities.Ativo;

public class CalculadoraAtivos {

	private List<Ativo> ativos;

	public CalculadoraAtivos(List<Ativo> ativos) {
		this.ativos = ativos;
	}

	public List<Double> mediaMovelAritmetica(int periodo) {

		List<Double> medias = new ArrayList<>();

		for (int i = 0; i < ativos.size() - periodo; i++) {
			double media = 0.0;

			for (int j = i; j < (i + periodo); j++) {
				media += ativos.get(i).getClose();
			}

			medias.add(media /= periodo);
		}

		return medias;
	}

	public List<Double> mediaMovelExponencial(int periodo) {

		List<Double> medias = new ArrayList<>();
		double multiplicador = 2.0 / (periodo + 1);
		medias.add(mediaMovelAritmetica(periodo).get(0));

		for (int i = 1; i < (ativos.size() - periodo); i++) {
			double valor = ativos.get(i).getClose();
			medias.add(multiplicador * (valor - medias.get(i - 1)) + medias.get(i - 1));
		}

		return medias;
	}

	public void mediaTemporal(int periodo) {
		List<Double> aritmeticas = mediaMovelAritmetica(periodo);
		List<Double> exponenciais = mediaMovelExponencial(periodo);

		for (int i = 0; i < aritmeticas.size(); i++) {
			System.out.printf("Arit = %.4f || Exp = %.4f \n", aritmeticas.get(i), exponenciais.get(i));
		}
	}

	public double desvioPadrao() {
		double sum = 0.0;
		
		for (Ativo a : ativos)
			sum += a.getClose();
		
		double media = sum / (double) ativos.size();
		double desvios = 0.0;
		
		for (int i = 0; i < ativos.size(); i++)
			desvios += Math.pow(ativos.get(i).getClose() - media, 2);
		
		return Math.sqrt(desvios/(double)ativos.size());

	}
	
	public double drawdown() {
		double maior = -1.0;
		double menor = 1000.0;
		
		for(Ativo ativo : ativos) {
			if(ativo.getClose() > maior) maior = ativo.getClose();
			if(ativo.getClose() < menor) menor = ativo.getClose();
		}
		
		return (maior - menor) / maior ;
	}
	
}
