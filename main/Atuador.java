package main;

public class Atuador extends Produto {

	private TipoDeAtuador tipo;

	public Atuador(String nome, String fabricante, double preco, String codigo, TipoDeAtuador tipo) {
		super(TipoProduto.ATUADOR, nome, fabricante, preco, codigo);
		this.setTipo(tipo);
	}

	public TipoDeAtuador getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeAtuador tipo) {
		this.tipo = tipo;
	}
	
	public String imprimeInfoAtuador() {
		System.out.printf("Nome:%s%n", this.getNome());
		System.out.printf("Fabricante:%s%n", this.getFabricante());
		System.out.printf("Preco:%f%n", this.getPreco());
		System.out.printf("Codigo:%s%n", this.getCodigo());
		System.out.printf("Tipo de Atuador:%s%n", this.getTipo());
		return "-----";
	}
}
