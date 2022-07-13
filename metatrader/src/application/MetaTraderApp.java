package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import entities.Cotacao;
import utilities.CalculadoraCotacoes;
import utilities.LeitorCSV;

public class MetaTraderApp {

	public static void main(String[] args) {
		
		List<Cotacao> cotacoes = preencheCotacoes();
		CalculadoraCotacoes calc = new CalculadoraCotacoes(cotacoes);
		
		System.out.println(calc.media(40));
		
	}

	public static List<Cotacao> preencheCotacoes() {
		
		List<Cotacao> cotacoes = new ArrayList<>();
		LeitorCSV leitor = new LeitorCSV();
		
		try {
			leitor.abrir("EURUSDH1.csv");
			cotacoes = leitor.extrair();
			leitor.fechar();
			return cotacoes;
		} catch (ParseException e) {
			System.err.println("Houve um erro ao analisar o arquivo!");
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.err.println("Houve um erro ao manipular o arquivo!");
		}
		
		return null;
	}
	
}
