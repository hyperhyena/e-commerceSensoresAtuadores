package main;

import java.util.HashMap;

public class Estoque {

	HashMap<TipoDeSensor, Integer> estoqueSensor = new HashMap<TipoDeSensor, Integer>();
	HashMap<TipoDeAtuador, Integer> estoqueAtuador = new HashMap<TipoDeAtuador, Integer>();

	public void iniciar() {
		estoqueSensor.put(TipoDeSensor.INDUTIVO, 100);
		estoqueSensor.put(TipoDeSensor.CAPACITIVO, 100);
		estoqueSensor.put(TipoDeSensor.ULTRASSONICO, 100);
		
		estoqueAtuador.put(TipoDeAtuador.PNEUMATICO, 100);
		estoqueAtuador.put(TipoDeAtuador.ELETRICO, 100);
		estoqueAtuador.put(TipoDeAtuador.HIDRAULICO, 100);
		
	}
	
	public Integer getQuantidadeDeSensoresNoEstoque(TipoDeSensor tipoSensor) {
		return estoqueSensor.get(tipoSensor);
	}

	public void setQuantidadeSensoresNoEstoque(int quantidade, TipoDeSensor tipoDeSensor) {
		estoqueSensor.put(tipoDeSensor, quantidade);
	}

	public Integer getQuantidadeDeAtuadoresNoEstoque(TipoDeAtuador tipoAtuador) {
		return estoqueAtuador.get(tipoAtuador);
	}

	public void setQuantidadeAtuadoresNoEstoque(int quantidade, TipoDeAtuador tipoDeAtuador) {
		estoqueAtuador.put(tipoDeAtuador, quantidade);
	}

}
