package atuadores;

import main.Atuador;
import main.TipoDeAtuador;

public class Hidraulico extends Atuador {

	public Hidraulico(String nome, String fabricante, double preco, String codigo, TipoDeAtuador tipo) {
		super(nome, fabricante, preco, codigo, TipoDeAtuador.HIDRAULICO);
		this.nome = "BCH0602O12A1C";
		this.fabricante = "Schneider Electric";
		this.preco = 174.81;
		this.codigo = "005";

	}
}