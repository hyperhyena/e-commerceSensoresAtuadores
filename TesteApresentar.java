package testes;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Carrinho;
import main.Cliente;
import main.Estoque;
import main.TipoDeAtuador;
import main.TipoDeSensor;
import main.TipoProduto;

public class TesteApresentar {

	ArrayList<Cliente> clientes = new ArrayList<>();
	private Estoque estoque = new Estoque();
	private Cliente cliente = new Cliente(0, null, 0);
	private Carrinho carrinho = new Carrinho();

	@Before
	public void testeInsercao() {
		clientes.add(new Cliente(001, "João da Silva", 6234035));
		clientes.add(new Cliente(002, "Fabio Souza", 5485687));
		clientes.add(new Cliente(003, "Marcia Oliveira", 2965743));
		clientes.add(new Cliente(004, "Joana Campos", 8214965));

		estoque.setQuantidadeAtuadoresNoEstoque(100, TipoDeAtuador.PNEUMATICO);
		estoque.setQuantidadeAtuadoresNoEstoque(100, TipoDeAtuador.ELETRICO);
		estoque.setQuantidadeAtuadoresNoEstoque(100, TipoDeAtuador.HIDRAULICO);

		estoque.setQuantidadeSensoresNoEstoque(100, TipoDeSensor.INDUTIVO);
		estoque.setQuantidadeSensoresNoEstoque(100, TipoDeSensor.CAPACITIVO);
		estoque.setQuantidadeSensoresNoEstoque(100, TipoDeSensor.ULTRASSONICO);

	}

	@Test
	public void testeBusca() {
		assertNotNull(cliente.procuraClientePorRG(clientes, 6234035));
		
		carrinho.pesquisarProduto(TipoProduto.ATUADOR);
	}
	
	@Test
	public void testeListaClientes() {
		int c = clientes.size();
		int u;
		for (u = 0; u < c; u++) {
			System.out.println(clientes.get(u).imprimeCliente());
		}
	}
	
	@Test
	public void testeListagemCarrinhoERegraDeNegocio() {
		carrinho.continuarCompra();
		
	}
}
