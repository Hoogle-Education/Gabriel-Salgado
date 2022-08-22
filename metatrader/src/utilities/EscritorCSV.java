package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.Ativo;

public class EscritorCSV {

	private BufferedWriter writer;
	
	public void criar(String filename, String extension) throws IOException, IOException {
		File file = new File(" ");
		String path = file.getAbsolutePath();
		String pathname = path + "\\" + filename + "." + extension;
		writer = new BufferedWriter(new FileWriter(pathname));
	}
	
	public void escreverMedias(List<Double> medias) throws IOException {
		for(Double valor : medias) {
			writer.write(valor.toString() + "\n");
		}
	}
	
	public void escreverCotacoes(List<Ativo> cotacoes) throws IOException {
		for(Ativo conteudo : cotacoes) {
			writer.write(conteudo.toString() + "\n");
		}
	}
	
	public void fechar() throws IOException {
		writer.close();
	}
	
}
