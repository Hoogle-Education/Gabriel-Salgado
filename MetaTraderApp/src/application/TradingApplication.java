package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import entities.Ativo;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import utilities.file.EscritorExcel;
import utilities.file.LeitorCSV;

class TradingApplication {
	
	static List<Ativo> dados;
	static List<Double> medias;
	
	public TradingApplication() {
		dados = new ArrayList<>();
	}
	
	public void lerArquivo(String nomeDoArquivo) throws IOException, ParseException {
		
		LeitorCSV leitor = new LeitorCSV();
		
		try {
			leitor.abrir(nomeDoArquivo);
			dados = leitor.extrair();
		}catch(FileNotFoundException e1) {
			System.err.println("Erro ao encontrar o arquivo");
			throw e1;
		}catch(IOException e2) {
			System.err.println("Erro ao salvar no arquivo");
			throw e2;
		} catch (ParseException e3) {
			System.err.println("Erro ao Interpretar o arquivo");
			throw e3;
		}
		
		try{
			leitor.fechar();
		}catch(IOException e){
			System.err.println("Erro ao fechar o arquivo");
			throw e;
		}
	}
	
	
	
	public void escreverAtivos(String nomePlanilha, String nomeAba) throws IOException, RowsExceededException, WriteException {		
		EscritorExcel escritor = new EscritorExcel();
		try{
			escritor.criarPlanilha(nomePlanilha);
			escritor.criarAba(nomeAba);
			escritor.escreverAtivos(dados, nomeAba);
			escritor.fecharPlanilha();
		}catch(FileNotFoundException e1){
			System.err.println("Erro ao encontrar o arquivo");
			throw e1;
		}catch(IOException e2){
			System.err.println("Erro ao salvar no arquivo");
			throw e2;
		}catch(RowsExceededException e3) {
			System.err.println("Erro: Excedeu o limite de linhas");
			throw e3;
		}catch(WriteException e4) {
			System.err.println("Erro ao escrever na planilha");
			throw e4;
		}
	}
	
}