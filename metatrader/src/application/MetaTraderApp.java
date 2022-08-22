package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import entities.Ativo;
import utilities.CalculadoraAtivos;
import utilities.LeitorCSV;

public class MetaTraderApp extends JFrame {

	private static final long serialVersionUID = 1L;

	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		List<Ativo> cotacoes = preencheCotacoes();
		CalculadoraAtivos calc = new CalculadoraAtivos(cotacoes);
		int curta, intermediaria, longa;
		
		cotacoes.forEach(System.out::println);

//		for(double value : calc.mediaMovelAritmetica(6) ) {
//			System.out.printf("Média móvel aritmética = %.4f\n", value);
//		}

//		for (double value : calc.mediaMovelExponencial(6)) {
//			System.out.printf("Média móvel exponencial = %.4f\n", value);
//		}

//		System.out.println("Total de cotações no sistema: " + cotacoes.size());
//
//		System.out.print("Digite o período de média curta:");
//		curta = in.nextInt();
//
//		System.out.print("Digite o período de média intermediária:");
//		intermediaria = in.nextInt();
//
//		System.out.print("Digite o período de média longa:");
//		longa = in.nextInt();
//
//		System.out.println("Desvio = " + calc.desvioPadrao(cotacoes));
		
	}

	public static List<Ativo> preencheCotacoes() {

		List<Ativo> cotacoes = new ArrayList<>();
		LeitorCSV leitor = new LeitorCSV();

		try {
			leitor.abrir("metatrader.csv");
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
