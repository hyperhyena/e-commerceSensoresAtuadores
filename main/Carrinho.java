package main;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import atuadores.Eletrico;
import atuadores.Hidraulico;
import atuadores.Pneumatico;
import sensores.Capacitivo;
import sensores.Indutivo;
import sensores.Ultrassonico;

public class Carrinho {

	HashMap<TipoDeSensor, Integer> quantidadeSensores = new HashMap<TipoDeSensor, Integer>();
	HashMap<TipoDeAtuador, Integer> quantidadeAtuadores = new HashMap<TipoDeAtuador, Integer>();

	Scanner leitor = new Scanner(System.in);
	NumberFormat formatador = new DecimalFormat("#0.00");
	private Estoque estoque = new Estoque();

	private TipoDeSensor sensorPesquisaConvertido;
	private TipoDeAtuador atuadorPesquisaConvertido;

	private PrintStream adicionarAtuadorNoCarrinho(int quantidade, String tipoAtuador) {

		if (tipoAtuador.toUpperCase().equals(TipoDeAtuador.HIDRAULICO.toString())) {
			quantidadeAtuadores.put(TipoDeAtuador.HIDRAULICO, quantidade);
		}
		if (tipoAtuador.toUpperCase().equals(TipoDeAtuador.PNEUMATICO.toString())) {
			quantidadeAtuadores.put(TipoDeAtuador.PNEUMATICO, quantidade);
		}
		if (tipoAtuador.toUpperCase().equals(TipoDeAtuador.ELETRICO.toString())) {
			quantidadeAtuadores.put(TipoDeAtuador.ELETRICO, quantidade);
		}
		return System.out.printf("%d atuadores do tipo %s foram inseridos com sucesso\n", quantidade, tipoAtuador);
	}

	private PrintStream adicionarSensorNoCarrinho(int quantidade, String tipoSensor) {
		if (tipoSensor.toUpperCase().equals(TipoDeSensor.INDUTIVO.toString())) {
			quantidadeSensores.put(TipoDeSensor.INDUTIVO, quantidade);
		}
		if (tipoSensor.toUpperCase().equals(TipoDeSensor.CAPACITIVO.toString())) {
			quantidadeSensores.put(TipoDeSensor.CAPACITIVO, quantidade);
		}
		if (tipoSensor.toUpperCase().equals(TipoDeSensor.ULTRASSONICO.toString())) {
			quantidadeSensores.put(TipoDeSensor.ULTRASSONICO, quantidade);
		}
		return System.out.printf("%d sensores do tipo %s foram inseridos com sucesso\n", quantidade, tipoSensor);
	}

	public void listarCarrinho() {
		Set<Map.Entry<TipoDeAtuador, Integer>> a = quantidadeAtuadores.entrySet();
		System.out.println("Atuador  |   Quantidade");
		for (Map.Entry<TipoDeAtuador, Integer> iteration : a) {
			System.out.println(iteration.getKey() + " | " + iteration.getValue());
		}

		Set<Map.Entry<TipoDeSensor, Integer>> s = quantidadeSensores.entrySet();
		System.out.println("Sensor  |   Quantidade");
		for (Map.Entry<TipoDeSensor, Integer> iteration : s) {
			System.out.println(iteration.getKey() + " | " + iteration.getValue());
		}
	}

	public void listarCarrinhoDetalhado() {
		Set<Map.Entry<TipoDeAtuador, Integer>> a = quantidadeAtuadores.entrySet();
		System.out.println("INFORMAÇÃO ATUADOR");
		System.out.println("_____");
		for (Map.Entry<TipoDeAtuador, Integer> mapaA : a) {
			TipoDeAtuador chave = mapaA.getKey();
			if (chave.equals(TipoDeAtuador.ELETRICO)) {
				new Eletrico(null, null, 0, null, chave).imprimeInfoAtuador();
			} else if (chave.equals(TipoDeAtuador.HIDRAULICO)) {
				new Hidraulico(null, null, 0, null, chave).imprimeInfoAtuador();
			} else if (chave.equals(TipoDeAtuador.PNEUMATICO)) {
				new Pneumatico(null, null, 0, null, chave).imprimeInfoAtuador();
			}
			System.out.println("QUANTIDADE   | " + mapaA.getValue());
			System.out.println("____");
		}

		Set<Entry<TipoDeSensor, Integer>> s = quantidadeSensores.entrySet();
		System.out.println("INFORMAÇÃO SENSOR\n");
		for (Entry<TipoDeSensor, Integer> mapaS : s) {
			TipoDeSensor chave = mapaS.getKey();
			if (chave.equals(TipoDeSensor.CAPACITIVO)) {
				new Capacitivo(null, null, 0, null, chave).imprimeInfoSensor();
			} else if (chave.equals(TipoDeSensor.INDUTIVO)) {
				new Indutivo(null, null, 0, null, chave).imprimeInfoSensor();
			} else if (chave.equals(TipoDeSensor.ULTRASSONICO)) {
				new Ultrassonico(null, null, 0, null, chave).imprimeInfoSensor();
			}
			System.out.println("QUANTIDADE   | " + mapaS.getValue());
			System.out.println("____");
		}
		
		System.out.println(formatador.format(mostrarPrecoTotal()));
	}

	public void pesquisarProduto(TipoProduto tipoProduto) {
		estoque.iniciar();
		if (tipoProduto == TipoProduto.SENSOR) {
			System.out.println("Qual tipo de sensor?");
			String sensorPesquisa = leitor.nextLine();
			TipoDeSensor stringConvertida = converteStringPraEnumSensor(sensorPesquisa);
			Integer sensoresNoEstoque = estoque.getQuantidadeDeSensoresNoEstoque(stringConvertida);
			System.out.printf("A quantidade de sensores do tipo %s no estoque é %d", sensorPesquisa, sensoresNoEstoque);
		}
		if (tipoProduto == TipoProduto.ATUADOR) {
			System.out.println("Qual tipo de atuador?");
			String atuadorPesquisa = leitor.nextLine();

			TipoDeAtuador stringConvertida = converteStringPraEnumAtuador(atuadorPesquisa);
			Integer atuadoresNoEstoque = estoque.getQuantidadeDeAtuadoresNoEstoque(stringConvertida);

			System.out.printf("A quantidade de atuadores do tipo %s no estoque é %d", atuadorPesquisa,
					atuadoresNoEstoque);
		}

	}

	private TipoDeSensor converteStringPraEnumSensor(String entrada) {
		if (entrada.toUpperCase().equals(TipoDeSensor.INDUTIVO.toString())) {
			sensorPesquisaConvertido = TipoDeSensor.INDUTIVO;
		}
		if (entrada.toUpperCase().equals(TipoDeSensor.CAPACITIVO.toString())) {
			sensorPesquisaConvertido = TipoDeSensor.CAPACITIVO;
		}
		if (entrada.toUpperCase().equals(TipoDeSensor.ULTRASSONICO.toString())) {
			sensorPesquisaConvertido = TipoDeSensor.ULTRASSONICO;
		}
		return sensorPesquisaConvertido;
	}

	private TipoDeAtuador converteStringPraEnumAtuador(String entrada) {
		if (entrada.toUpperCase().equals(TipoDeAtuador.HIDRAULICO.toString())) {
			atuadorPesquisaConvertido = TipoDeAtuador.HIDRAULICO;
		}
		if (entrada.toUpperCase().equals(TipoDeAtuador.PNEUMATICO.toString())) {
			atuadorPesquisaConvertido = TipoDeAtuador.PNEUMATICO;
		}
		if (entrada.toUpperCase().equals(TipoDeAtuador.ELETRICO.toString())) {
			atuadorPesquisaConvertido = TipoDeAtuador.ELETRICO;
		}
		return atuadorPesquisaConvertido;
	}

	public void removerProdutoDoCarrinho() {
		System.out.println("Tipo de Produto a ser removido");
		String tipoProduto = leitor.nextLine();

		if (tipoProduto.toUpperCase().equals(TipoProduto.ATUADOR.toString())) {

			System.out.println("Tipo de Atuador");
			String atuadorARemover = leitor.nextLine();
			System.out.println("Quantidade a ser removida");
			int quantidadeA = Integer.parseInt(leitor.nextLine());

			TipoDeAtuador atuadorARemoverConvertido = converteStringPraEnumAtuador(atuadorARemover);
			Integer valorAtualDeAtuadores = quantidadeAtuadores.get(atuadorARemoverConvertido);

			int novaQuantidadeA = valorAtualDeAtuadores - quantidadeA;
			if (novaQuantidadeA >= 0) {
				quantidadeAtuadores.put(atuadorARemoverConvertido, novaQuantidadeA);
				System.out.printf("%d unidades do atuador %s foram removidos", quantidadeA, atuadorARemover);
			} else {
				System.out.println("Valor excede a quantidade de atuadores no carrinho.");
			}
		}
		if (tipoProduto.toUpperCase().equals(TipoProduto.SENSOR.toString())) {
			System.out.println("Tipo de Sensor");
			String sensorARemover = leitor.nextLine();
			System.out.println("Quantidade a ser removida");
			int quantidadeS = Integer.parseInt(leitor.nextLine());

			TipoDeSensor sensorARemoverConvertido = converteStringPraEnumSensor(sensorARemover);
			Integer valorAtualDeSensores = quantidadeSensores.get(sensorARemoverConvertido);

			int novaQuantidadeS = valorAtualDeSensores - quantidadeS;
			if (novaQuantidadeS >= 0) {
				quantidadeSensores.put(sensorARemoverConvertido, novaQuantidadeS);
				System.out.printf("%d unidades do sensor %s foram removidos", quantidadeS, sensorARemover);
			} else {
				System.out.println("Valor excede a quantidade de sensores no carrinho.");
			}
		}

	}

	public double mostrarPrecoTotal() {
		double precoTotal = 0;
		double precoSensor = 0;
		double precoAtuador = 0;

		for (Map.Entry<TipoDeSensor, Integer> valor : quantidadeSensores.entrySet()) {
			TipoDeSensor chave = valor.getKey();
			Integer quantidade = valor.getValue();

			if (quantidade > 0) {
				if (chave.equals(TipoDeSensor.CAPACITIVO)) {
					Capacitivo sensorCapacitivo = new Capacitivo(null, null, 0, null, null);
					precoSensor = sensorCapacitivo.getPreco() * quantidade;
					precoTotal = precoTotal + precoSensor;

				} else if (chave.equals(TipoDeSensor.INDUTIVO)) {
					Indutivo sensorIndutivo = new Indutivo(null, null, 0, null, null);
					precoSensor = sensorIndutivo.getPreco() * quantidade;
					precoTotal = precoTotal + precoSensor;

				} else if (chave.equals(TipoDeSensor.ULTRASSONICO)) {
					Ultrassonico sensorUltra = new Ultrassonico(null, null, 0, null, null);
					precoSensor = sensorUltra.getPreco() * quantidade;
					precoTotal = precoTotal + precoSensor;

				}
			}
		}

		for (Entry<TipoDeAtuador, Integer> valor : quantidadeAtuadores.entrySet()) {
			TipoDeAtuador chave = valor.getKey();
			Integer quantidade = valor.getValue();

			if (quantidade > 0) {
				if (chave.equals(TipoDeAtuador.ELETRICO)) {
					Eletrico atuadorEletrico = new Eletrico(null, null, 0, null, null);
					precoAtuador = atuadorEletrico.getPreco() * quantidade;
					precoTotal = precoTotal + precoAtuador;

				} else if (chave.equals(TipoDeAtuador.HIDRAULICO)) {
					Hidraulico atuadorHidraulico = new Hidraulico(null, null, 0, null, null);
					precoAtuador = atuadorHidraulico.getPreco() * quantidade;
					precoTotal = precoTotal + precoAtuador;

				} else if (chave.equals(TipoDeAtuador.PNEUMATICO)) {
					Ultrassonico atuadorUltrassonico = new Ultrassonico(null, null, 0, null, null);
					precoAtuador = atuadorUltrassonico.getPreco() * quantidade;
					precoTotal = precoTotal + precoAtuador;

				}
			}
		}
		
		return precoTotal;
	}

	public void continuarCompra() {
		int opcao = 0;
		do {
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("Opção 1 - Comprar atuador");
			System.out.println("Opção 2 - Comprar sensores");
			System.out.println("Opção 3 - Ver carrinho");
			System.out.println("Opção 4 - Remover item do carrinho");
			System.out.println("Opção 0 - Finalizar compras");

			System.out.println("Digite sua escolha: ");
			opcao = Integer.parseInt(leitor.nextLine());

			if (opcao == 1) {
				compraAtuadores();
			} else if (opcao == 2) {
				compraSensores();
			} else if (opcao == 3) {
				listarCarrinhoDetalhado();
			} else if (opcao == 4) {
				removerProdutoDoCarrinho();
			}

		} while (opcao != 0);
		finalizarPedido();

	}

	private void finalizarPedido() {
		estoque.iniciar();
		double carrinhoFechado = mostrarPrecoTotal();
		if (carrinhoFechado == 0.00) {
			System.out.println("Pedido finalizado. Seu carrinho estava vazio.");
		} else {
			System.out.println("Pedido finalizado. Seu carrinho: ");
			listarCarrinhoDetalhado();
			System.out.printf("\nO valor total é %.2f", carrinhoFechado);
			for (Entry<TipoDeAtuador, Integer> valor : quantidadeAtuadores.entrySet()) {
				TipoDeAtuador chave = valor.getKey();
				Integer quantidade = valor.getValue();
				Integer qtdEstoqueA = estoque.getQuantidadeDeAtuadoresNoEstoque(chave);
				qtdEstoqueA = qtdEstoqueA - quantidade;
				estoque.setQuantidadeAtuadoresNoEstoque(qtdEstoqueA, chave);
			}
			for (Entry<TipoDeSensor, Integer> valor : quantidadeSensores.entrySet()) {
				TipoDeSensor chave = valor.getKey();
				Integer quantidade = valor.getValue();
				Integer qtdEstoqueS = estoque.getQuantidadeDeSensoresNoEstoque(chave);
				qtdEstoqueS = qtdEstoqueS - quantidade;
				estoque.setQuantidadeSensoresNoEstoque(qtdEstoqueS, chave);
			}
		}
	}

	private void compraSensores() {
		System.out.println("Qual tipo de sensor?");
		String tipoSensor = leitor.nextLine();
		System.out.println("Qual a quantidade?");
		int qtdSensor = Integer.parseInt(leitor.nextLine());
		adicionarSensorNoCarrinho(qtdSensor, tipoSensor);
		listarCarrinho();
	}

	private void compraAtuadores() {
		System.out.println("Qual tipo de atuador?");
		String tipoAtuador = leitor.nextLine();
		System.out.println("Qual a quantidade?");
		int qtdAtuador = Integer.parseInt(leitor.nextLine());
		adicionarAtuadorNoCarrinho(qtdAtuador, tipoAtuador);
		listarCarrinho();
	}
}
