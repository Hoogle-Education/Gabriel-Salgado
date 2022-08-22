package utilities.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Ativo;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class EscritorExcel {

	private WritableWorkbook planilha;
	private WritableSheet abaPlanilha;
	private List<String> tabnames;
	
	public void criarPlanilha(String filename) throws IOException, IOException {
		File file = new File(" ");
		String path = file.getAbsolutePath();
		String pathname = path + "\\" + filename + ".xls";
		planilha = Workbook.createWorkbook(new File(pathname));
		tabnames = new ArrayList<>();
	}
	
	public void criarAba(String tabname) throws IOException, IOException {		
		abaPlanilha = planilha.createSheet(tabname, 0);
		tabnames.add(tabname);
	}
	
	public void escreverMedias(List<Double> medias, String tabname) throws IOException, RowsExceededException, WriteException {
		
		if(!tabnames.contains(tabname)) {
			throw new IOException();
		}
		
		String[] header = {
			"ID",
			"Valor"
		};
		
		WritableCellFormat cellFormat = new WritableCellFormat();
		
		WritableFont font = new WritableFont(WritableFont.ARIAL);
		font.setBoldStyle(WritableFont.BOLD);
		
		cellFormat.setFont(font);
		
		for(int i = 0; i < header.length; i++) {
			Label label = new Label(i, 0, header[i]);
			abaPlanilha.addCell(label);
		}
		
		int linha = 1;
		for(Double valor : medias) {
			jxl.write.Number indexLinha = new jxl.write.Number(0, linha, linha);
			jxl.write.Number resultado = new jxl.write.Number(1, linha++, valor); 
			abaPlanilha.addCell(indexLinha);
			abaPlanilha.addCell(resultado);
		}
		
		planilha.write();
	}
	
	public void escreverCotacoes(List<Ativo> cotacoes, String tabname) throws IOException {
		
		if(!tabnames.contains(tabname)) {
			throw new IOException();
		}
		
		for(Ativo ativo : cotacoes) {
			ativo.get
		}
		
		planilha.write();
	}
	
	public void fechar() throws IOException, WriteException {
		planilha.close();
	}
	
}
