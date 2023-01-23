package atuadores;

import main.Atuador;
import main.TipoDeAtuador;

public class Pneumatico extends Atuador {

	public Pneumatico(String nome, String fabricante, double preco, String codigo, TipoDeAtuador tipo) {
		super(nome, fabricante, preco, codigo, TipoDeAtuador.PNEUMATICO);
		this.nome = "ADN-32-120-I-P-A";
		this.fabricante = "FESTO";
		this.preco = 331.00;
		this.codigo = "006";
	}

    
}