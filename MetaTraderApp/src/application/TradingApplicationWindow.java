package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Ativo;
import utilities.file.EscritorExcel;
import utilities.file.LeitorCSV;


public class TradingApplicationWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JTable tabelaTrading;
	TradingApplication tradingApplication;
	DefaultTableModel modelo;
	JMenuBar menu;
	JMenu menuArquivo, menuCliente;
	JMenuItem menuItemLer, menuItemEscrever, menuItemVender, menuItemComprar;
	
	public TradingApplicationWindow(String title) {
		super(title);
		tradingApplication = new TradingApplication();
		
		String[] colunas = { 
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
		
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);
		
		tabelaTrading = new JTable();
		tabelaTrading.setModel(modelo);
		
		JScrollPane scroll = new JScrollPane(tabelaTrading);
		add(scroll);
		
		scroll.addComponentListener( new ComponentAdapter() {
	      @Override
	      public void componentResized( ComponentEvent e){
	        tabelaTrading.getColumnModel().getColumn(0).setPreferredWidth(scroll.getWidth()*1/50);
	        tabelaTrading.getColumnModel().getColumn(1).setPreferredWidth(scroll.getWidth()*1/50);
	        tabelaTrading.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	      }
	    });
		
		menu();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(1000, 600);
	    setVisible(true);
	}
	
	
	public void menu() {
		menu = new JMenuBar();
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new TradingApplicationWindow("Trading project");
	}
	
}
