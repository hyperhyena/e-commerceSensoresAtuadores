package sensores;

import main.Sensor;
import main.TipoDeSensor;

public class Ultrassonico extends Sensor {

	public Ultrassonico(String nome, String fabricante, double preco, String codigo, TipoDeSensor tipoSensor) {
		super(nome, fabricante, preco, codigo, TipoDeSensor.ULTRASSONICO);
		this.nome = "Grove";
		this.fabricante = "seeed";
		this.preco = 38.90;
		this.codigo = "003";
	}

}