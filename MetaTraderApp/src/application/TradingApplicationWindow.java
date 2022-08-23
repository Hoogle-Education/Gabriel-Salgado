package application;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.FormatterClosedException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Ativo;
import entities.Corretora;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TradingApplicationWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JTable tabelaTrading;
	TradingApplication tradingApplication;
	Corretora corretora;
	DefaultTableModel modelo;
	JMenuBar menu;
	JMenu menuArquivo, menuCliente;
	JMenuItem menuItemLer, menuItemEscrever, menuItemFechar, menuItemVender, menuItemComprar;

	public TradingApplicationWindow(String title) {
		super(title);
		tradingApplication = new TradingApplication();

		String[] colunas = { "ID", "Date", "Open", "High", "Low", "Close", "Ticket Volume", "Volume", "Spread" };

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colunas);

		tabelaTrading = new JTable();
		tabelaTrading.setModel(modelo);

		JScrollPane scroll = new JScrollPane(tabelaTrading);
		add(scroll);

		scroll.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				tabelaTrading.getColumnModel().getColumn(0).setPreferredWidth(scroll.getWidth() * 1 / 100);
				tabelaTrading.getColumnModel().getColumn(1).setPreferredWidth(scroll.getWidth() * 1 / 10);
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

		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A);

		menuItemLer = new JMenuItem("Ler arquivo");
		menuItemLer.setMnemonic(KeyEvent.VK_A);
		menuItemLer.addActionListener(this);
		menuArquivo.add(menuItemLer);

		menuItemEscrever = new JMenuItem("Escrever em arquivo");
		menuItemEscrever.setMnemonic(KeyEvent.VK_W);
		menuItemEscrever.addActionListener(this);
		menuArquivo.add(menuItemEscrever);

		menuArquivo.addSeparator();

		menuItemFechar = new JMenuItem("Fechar");
		menuItemFechar.setMnemonic(KeyEvent.VK_F);
		menuItemFechar.addActionListener(this);
		menuArquivo.add(menuItemFechar);

		menuCliente = new JMenu("Operacoes Cliente");
		menuCliente.setMnemonic(KeyEvent.VK_O);

		menuItemComprar = new JMenuItem("Fechar");
		menuItemComprar.setMnemonic(KeyEvent.VK_C);
		menuItemComprar.addActionListener(this);
		menuCliente.add(menuItemComprar);

		menuItemVender = new JMenuItem("Fechar");
		menuItemVender.setMnemonic(KeyEvent.VK_V);
		menuItemVender.addActionListener(this);
		menuCliente.add(menuItemVender);

		menu.add(menuArquivo);
		menu.add(menuCliente);

		setJMenuBar(menu);
	}

	public void showAtivos(){
	    modelo.setRowCount(0);
	    List<Ativo> ativos = tradingApplication.dados;
	    Object[] data = new Object[9];
	    int pos = 1;
	    for(Ativo ativo : ativos){
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	      data[0] = pos;
	      data[1] = formatter.format(ativo.getDate());
	      data[2] = ativo.getOpen();
	      data[3] = ativo.getClose();
	      data[4] = ativo.getHigh();
	      data[5] = ativo.getLow();
	      data[6] = ativo.getTicketVolume();
	      data[7] = ativo.getVolume();
	      data[8] = ativo.getSpread();
	      modelo.addRow(data);
	      pos++;
	    }
	  }

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == menuItemFechar) {
			System.exit(0);
		} else if (event.getSource() == menuItemLer) {
			FileDialog fileopen = new FileDialog(this, "Abrir aquivo de Cidades", FileDialog.LOAD);

			fileopen.setFile("*.csv");
			fileopen.setVisible(true);

			if (fileopen.getFile() != null) {
				String filename = fileopen.getFile();

				try {
					tradingApplication.lerArquivo(filename);
				} catch (IOException iox) {
					JOptionPane.showMessageDialog(this, iox, "Erro de leitura", JOptionPane.ERROR_MESSAGE);
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(this, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				} finally {
					showAtivos();
				}
			}
		} else if (event.getSource() == menuItemEscrever) {
			FileDialog filesave = new FileDialog(this, "Salvar aquivo de Cidades", FileDialog.SAVE);

			filesave.setVisible(true);

			if (filesave.getFile() != null) {
				String filename = filesave.getFile();

				try {
					tradingApplication.escreverAtivos(filename, "outputTab");
				} catch (IOException iox) {
					JOptionPane.showMessageDialog(this, iox, "Erro no salvamento", JOptionPane.ERROR_MESSAGE);
				} catch (FormatterClosedException fcx) {
					JOptionPane.showMessageDialog(this, fcx, "Erro no salvamento", JOptionPane.ERROR_MESSAGE);
				} catch (RowsExceededException e) {
					JOptionPane.showMessageDialog(this, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				} catch (WriteException e) {
					JOptionPane.showMessageDialog(this, e, e.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public static void main(String[] args) {
		new TradingApplicationWindow("Trading project");
	}

}
