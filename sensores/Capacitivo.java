package sensores;

import main.Sensor;
import main.TipoDeSensor;

public class Capacitivo extends Sensor {

	public Capacitivo(String nome, String fabricante, double preco, String codigo, TipoDeSensor tipoSensor) {
		super(nome, fabricante, preco, codigo, TipoDeSensor.CAPACITIVO);
		this.nome = " 8Mm XT218A1PAL2";
		this.fabricante = "Schneider Electric";
		this.preco = 294.99;
		this.codigo = "002";
	}

}