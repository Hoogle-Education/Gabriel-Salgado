package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Cotacao;
import entities.Moeda;

public class LeitorCSV {

	private BufferedReader reader;

	// IOXException - Input and Output Exception
	public void abrir(String nomeDoArquivo) throws FileNotFoundException, IOException {
		File path = new File("");
		String pathname = path.getAbsolutePath() + "\\" + nomeDoArquivo;
		reader = new BufferedReader(new FileReader(pathname));
	}

	public List<Cotacao> extrair() throws IOException, ParseException {
		
		List<Cotacao> cotacoes = new ArrayList<>();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		String linha;
		
		// linha recebe o conteúdo do arquivo
		// enquanto tiver linha eu continuo lendo
		while ((linha = reader.readLine()) != null) {
			String[] dados = linha.split(",");
			cotacoes.add(new Cotacao(formatador.parse(dados[0]),
					new Moeda(Double.parseDouble(dados[1]), Double.parseDouble(dados[2])),
					new Moeda(Double.parseDouble(dados[3]), Double.parseDouble(dados[4])),
					Integer.parseInt(dados[5]), Integer.parseInt(dados[6])) );
		}
		
		return cotacoes;
	}
	
	public void fechar() throws IOException {
		reader.close();
	}

}
