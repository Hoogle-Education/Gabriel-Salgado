package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ativo {

	private Date date;
	private double open;
	private double high;
	private double low;
	private double close;
	private int ticketVolume;
	private int volume;
	private int spread;

	public Ativo() {
	}

	public Ativo(Date date, double open, double high, double low, double close, int ticketVolume, int volume,
			int spread) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.ticketVolume = ticketVolume;
		this.volume = volume;
		this.spread = spread;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getTicketVolume() {
		return ticketVolume;
	}

	public void setTicketVolume(int ticketVolume) {
		this.ticketVolume = ticketVolume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getSpread() {
		return spread;
	}

	public void setSpread(int spread) {
		this.spread = spread;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String aux = "";

		aux += "--------------------------------------------\n";
		aux += "|          Data: " + formatador.format(date) + "          |";
		aux += "\n--------------------------------------------\n";		
		aux += "|   High   |   Low   |   Open   |   Close  |\n";
		aux += "|  " + String.format("%.4f", high) 
				+ "  | " + String.format("%.4f", low) 
				+ "  |  " + String.format("%.4f", open) 
				+ "  |  " + String.format("%.4f", close) 
				+ "  | ";
		aux += "\n--------------------------------------------\n";	
		aux +="|  Ticket Volume  |   Volume   |   Spread  |\n";
		aux += "|       " + ticketVolume + "      |      " + volume + "     |      " + spread + "    |";
		aux += "\n--------------------------------------------\n";
		
		return aux;
	}

}
