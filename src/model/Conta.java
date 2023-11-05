package model;

public class Conta {

	public int numero;
	public String nome;
	public double saldo;
	
	public Conta() {
		super();
	}

	public Conta(int numero, String nome, float saldo) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Numero da conta:" + numero + ", Nome do titular:" + nome + ", Saldo: R$" + saldo ;
	}
	
	
	
	

}
