package application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import entities.Ativo;

public class PlotApplication extends ApplicationFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private TimeSeries series;
	
	public PlotApplication(String applicationTitle) {
		super(applicationTitle);
		series = new TimeSeries("Close values line", Minute.class);
		
		JFreeChart lineChart = ChartFactory.createLineChart(
				"Cotacoes x Tempo",
				"Time in minutes",
				"Cotacao",
				createDataset(),
				PlotOrientation.VERTICAL,
				true, true, true);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		
		final JButton buttom = new JButton("Plot Next");
		
		buttom.setActionCommand("NEXT");
		buttom.addActionListener(this);
		
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(chartPanel);
		panel.add(buttom, BorderLayout.SOUTH);
		
		chartPanel.setPreferredSize( new java.awt.Dimension(500, 270) );
		setContentPane(chartPanel);
	}
	
	  private DefaultCategoryDataset createDataset( ) {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      BaseApp app = new BaseApp();
	      BaseApp.preencheDados();
	      
	      for(Ativo cotacao : BaseApp.ativos) {
	    	  dataset.addValue(	cotacao.getClose() , "cotacao" , cotacao.getDate() );
	      }
	      
	      return dataset;
	  }
	
	
	@Override
	public void actionPerformed(ActionEvent action) {
		if(action.getActionCommand().equals("NEXT")) {
			Double nextValue = BaseApp.getNextCalculation();
			Minute minute = new Minute(BaseApp.getNextAtivo().getDate()) ;
			System.out.println("minute=" + minute.toString());
			series.add(minute,nextValue);
		} 
		
	}
	
	public static void main(String[] args) {
		new BaseApp(40);
			
		
		PlotApplication chart = new PlotApplication("MetaTrader App");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}

}
