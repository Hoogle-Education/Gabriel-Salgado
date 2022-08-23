package utilities.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Ativo;

import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
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
		String pathname = path.strip() + filename;
		System.out.println(pathname);
		planilha = Workbook.createWorkbook(new File(pathname));
		tabnames = new ArrayList<>();
	}

	public void criarAba(String tabname) throws IOException, IOException {
		abaPlanilha = planilha.createSheet(tabname, 0);
		tabnames.add(tabname);
	}

	public void escreverMedias(List<Double> medias, String tabname)
			throws RowsExceededException, WriteException, IOException {

		if (!tabnames.contains(tabname)) {
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

		for (int i = 0; i < header.length; i++) {
			Label label = new Label(i, 0, header[i]);
			abaPlanilha.addCell(label);
		}

		int linha = 1;

		for (Double valor : medias) {
			Number indexLinha = new Number(0, linha, linha);
			abaPlanilha.addCell(indexLinha);
			
			Number resultado = new Number(1, linha++, valor);
			abaPlanilha.addCell(resultado);
		}

		planilha.write();
	}

	public void escreverAtivos(List<Ativo> cotacoes, String tabname) 
			throws RowsExceededException, WriteException, IOException {

		if (!tabnames.contains(tabname)) {
			throw new IOException();
		}

		String[] header = { 
			"ID",
			"Date",
			"Open",
			"High",
			"Low",
			"Close",
			"Ticket Volume",
			"Volume",
			"Spread"
		};

		WritableCellFormat cellFormat = new WritableCellFormat();

		WritableFont font = new WritableFont(WritableFont.ARIAL);
		font.setBoldStyle(WritableFont.BOLD);

		cellFormat.setFont(font);

		for (int i = 0; i < header.length; i++) {
			Label label = new Label(i, 0, header[i]);
			abaPlanilha.addCell(label);
		}
		
		int linha = 1;
		for (Ativo ativo : cotacoes) {
			jxl.write.Number indexLinha = new jxl.write.Number(0, linha, linha);
			abaPlanilha.addCell(indexLinha);
			
			Date date = ativo.getDate();
			DateFormat customformatter = new DateFormat("dd/MM/yyyy hh:mm");
			WritableCellFormat formatter = new WritableCellFormat(customformatter);
			DateTime dateCell = new DateTime(1, linha, date, formatter);
			abaPlanilha.addCell(dateCell);
			
			Number number;
			
			number = new Number(2, linha, ativo.getOpen());
			abaPlanilha.addCell(number);
			
			number = new Number(3, linha, ativo.getClose());
			abaPlanilha.addCell(number);
			
			number = new Number(4, linha, ativo.getHigh());
			abaPlanilha.addCell(number);
			
			number = new Number(5, linha, ativo.getLow());
			abaPlanilha.addCell(number);
			
			number = new Number(6, linha, ativo.getTicketVolume());
			abaPlanilha.addCell(number);
			
			number = new Number(7, linha, ativo.getVolume());
			abaPlanilha.addCell(number);
			
			number = new Number(8, linha, ativo.getSpread());
			abaPlanilha.addCell(number);
			
			linha++;
		}

		planilha.write();
	}

	public void fecharPlanilha() throws IOException, WriteException {
		planilha.close();
	}

}
