package main;

public class Produto {
	protected String nome;
	protected String fabricante;
	protected double preco;
	protected String codigo;

	public Produto(TipoProduto tipoProduto, String nome, String fabricante, double preco, String codigo) {
		this.nome = nome;
		this.fabricante = fabricante;
		this.preco = preco;
		this.codigo = codigo;
	}

	public void info() {
		System.out.printf("Nome:%s%n", this.getNome());
		System.out.printf("Fabricante:%s%n", this.getFabricante());
		System.out.printf("Preco:%f%n", this.getPreco());
		System.out.printf("Codigo:%s%n", this.getCodigo());
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public double getPreco() {
		return preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public void setPreco(double d) {
		this.preco = d;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}