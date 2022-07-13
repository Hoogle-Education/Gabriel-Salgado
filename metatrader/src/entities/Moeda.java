package entities;

public class Moeda {
	
	private String nome;
	private Double precoVenda;
	private Double precoCompra;
	
	public Moeda(Double precoVenda, Double precoCompra) {
		this.precoVenda = precoVenda;
		this.precoCompra = precoCompra;
	}

	public Moeda(String nome, Double precoVenda, Double precoCompra) {
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.precoCompra = precoCompra;
	}

	public String getNome() {
		return nome;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	@Override
	public String toString() {
		String aux = "Moeda[nome=";
		
		if(nome == null) {
			aux += "S/N";
		} else {
			aux += nome;
		}
		
		aux +=", buy=R$" + precoVenda + ", sell=R$" + precoCompra + "]";
		
		return aux;
	}
	
	
	
}
