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

import entities.Ativo;

public class LeitorCSV {

	private BufferedReader reader;

	// IOXException - Input and Output Exception
	public void abrir(String nomeDoArquivo) throws FileNotFoundException, IOException {
		File path = new File("");
		String pathname = path.getAbsolutePath() + "\\" + nomeDoArquivo;
		System.out.println(pathname);
		reader = new BufferedReader(new FileReader(pathname));
	}

	public List<Ativo> extrair() throws IOException, ParseException {

		List<Ativo> cotacoes = new ArrayList<>();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy.MM.dd	HH:mm:ss");
		String linha;

		reader.readLine();

		// linha recebe o conteúdo do arquivo
		// enquanto tiver linha eu continuo lendo
		while ((linha = reader.readLine()) != null) {
			String data = linha.substring(0, 19);
			String[] dados = linha.substring(20).split("\t");
			cotacoes.add(new Ativo(formatador.parse(data), Double.parseDouble(dados[0]),
					Double.parseDouble(dados[1]), Double.parseDouble(dados[2]), Double.parseDouble(dados[3]),
					Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6]) ));
		}

		return cotacoes;
	}

	public void fechar() throws IOException {
		reader.close();
	}

}
