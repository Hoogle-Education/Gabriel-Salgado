package application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PlotApplication extends ApplicationFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private TimeSeries series;
	
	public PlotApplication(String applicationTitle) {
		super(applicationTitle);
		series = new TimeSeries("Close values line", Minute.class);
		final TimeSeriesCollection dataset = new TimeSeriesCollection(series);
		final JFreeChart chart = createChart(dataset);
		
		final ChartPanel chartPanel = new ChartPanel(chart);
		final JButton buttom = new JButton("Plot Next");
		
		buttom.setActionCommand("NEXT");
		buttom.addActionListener(this);
		
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(chartPanel);
		panel.add(buttom, BorderLayout.SOUTH);
		
		chartPanel.setPreferredSize( new java.awt.Dimension(500, 270) );
		setContentPane(chartPanel);
	}
	
	private JFreeChart createChart(final XYDataset dataset) {
		final JFreeChart result = ChartFactory.createTimeSeriesChart(
				"Trading oscilations demo", 
				"Time", "Value", 
				dataset, true, true, false);
			
		final XYPlot plot = result.getXYPlot();
		ValueAxis axis = plot.getDomainAxis();
		axis.setAutoRange(true);
		axis.setFixedAutoRange(96*60); // 
		axis = plot.getRangeAxis();
		axis.setRange(0.9, 1.2);
		
		return result;
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
