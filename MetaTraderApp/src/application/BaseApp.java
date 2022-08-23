package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import entities.Ativo;
import utilities.CalculadoraAtivos;
import utilities.enums.CalculationMode;
import utilities.file.LeitorCSV;

public class BaseApp {

	public static List<Ativo> ativos;
	private static List<Double> calculations;
	private static CalculadoraAtivos calculadora;
	private static Integer lastPos, lastAtivo;

	public BaseApp() {
		preencheDados();
		calculadora = new CalculadoraAtivos(ativos);
	}

	public BaseApp(int periodo) {
		preencheDados();
		calculadora = new CalculadoraAtivos(ativos);
		calculations = calculadora.mediaMovelAritmetica(periodo);
	}
	
	public static Ativo getNextAtivo() {
		if (isLastPosition(ativos)) {
			lastAtivo = null;
			return null;
		}

		if (lastAtivo == null) {
			lastAtivo = 0;
		}
		
		return ativos.get(lastAtivo);
	}

	public static Double getNextCalculation() {

		if (isLastPosition(calculations)) {
			lastPos = null;
			return null;
		}

		if (lastPos == null) {
			lastPos = 0;
			lastAtivo = 0;
		}

		return calculations.get(lastPos);

	}

	private static <T> boolean isLastPosition(List<T> lista) {
		return lastPos == lista.size();
	}

	public static void preencheDados() {

		LeitorCSV leitor = new LeitorCSV();

		try {
			leitor.abrir("metatrader.csv");
			ativos = leitor.extrair();
			leitor.fechar();
		} catch (ParseException e) {
			System.err.println("Houve um erro ao analisar o arquivo!");
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.err.println("Houve um erro ao manipular o arquivo!");
		}

	}
	
	public static void main(String[] args) {
		preencheDados();
		CalculadoraAtivos calc = new CalculadoraAtivos(ativos);
		
		List<Double> mediaCurta = calc.mediaMovelExponencial(20);
		List<Double> mediaIntermediaria = calc.mediaMovelExponencial(60);
		List<Double> mediaLonga = calc.mediaMovelExponencial(120);
		

		
		System.out.println("Desvio padrao = " + calc.desvioPadrao());
		
	}
	
}
