package main;

import java.util.ArrayList;

public class Cliente {

	private String nome;
	private int rg;
	private int numeroCadastro;

	public Cliente(int numeroCadastro, String nome, int rg) {
		this.numeroCadastro = numeroCadastro;
		this.nome = nome;
		this.rg = rg;
	}

	public String imprimeCliente() {
		System.out.printf("Numero Cadastro: %s%n", this.getNumeroCadastro());
		System.out.printf("Nome: %s%n", this.getNome());
		System.out.printf("RG: %d%n", this.getRG());
		return "------";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRG() {
		return rg;
	}

	public void setRG(int rg) {
		this.rg = rg;
	}

	public int getNumeroCadastro() {
		return numeroCadastro;
	}

	public void setNumeroCadastro(int numeroCadastro) {
		this.numeroCadastro = numeroCadastro;
	}
	
	public String procuraClientePorRG(ArrayList<Cliente> clientes, int documento){
		String nomeCliente = " ";
		for (Cliente cliente : clientes) {
			if (cliente.getRG() == documento) {
				nomeCliente = cliente.getNome();
				System.out.printf("Cliente %s\n", nomeCliente);
			} else {
				System.out.println("Cliente não encontrado");
			}
		}
		return nomeCliente;
	}

}