package main;

public class Sensor extends Produto {

	private TipoDeSensor tipoDeSensor;

	public Sensor(String nome, String fabricante, double preco, String codigo, TipoDeSensor tipoSensor) {
		super(TipoProduto.SENSOR, nome, fabricante, preco, codigo);
		this.setTipoSensor(tipoSensor);
	}

	public TipoDeSensor getTipoSensor() {
		return tipoDeSensor;
	}

	public void setTipoSensor(TipoDeSensor tipoSensor) {
		this.tipoDeSensor = tipoSensor;
	}

	public String imprimeInfoSensor() {
		System.out.printf("Nome:%s%n", this.getNome());
		System.out.printf("Fabricante:%s%n", this.getFabricante());
		System.out.printf("Preco:%f%n", this.getPreco());
		System.out.printf("Codigo:%s%n", this.getCodigo());
		System.out.printf("Tipo de Sensor: %s%n", this.getTipoSensor());
		return "-----";
	}
}
