package sensores;

import main.TipoDeSensor;
import main.Sensor;

public class Indutivo extends Sensor {

	public Indutivo(String nome, String fabricante, double preco, String codigo, TipoDeSensor tipoSensor) {
		super(nome, fabricante, preco, codigo, TipoDeSensor.INDUTIVO);
		this.nome = "NAMUR";
		this.fabricante = "Sense";
		this.preco = 528.18;
		this.codigo = "001";
	}

}