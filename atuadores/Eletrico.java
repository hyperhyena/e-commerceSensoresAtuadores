package atuadores;

import main.Atuador;
import main.TipoDeAtuador;

public class Eletrico extends Atuador {

	public Eletrico(String nome, String fabricante, double preco, String codigo, TipoDeAtuador tipo) {
		super(nome, fabricante, preco, codigo, TipoDeAtuador.ELETRICO);
		this.nome = "HG-KR23K";
		this.fabricante = "Mitsubishi Electric";
		this.preco = 325.33;
		this.codigo = "004";
	}

    
}