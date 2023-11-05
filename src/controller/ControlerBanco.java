package controller;

import bilbioteca.fila.dinamica.generica.model.Lista;
import model.Conta;

public class ControlerBanco {

	Lista<Conta>[] tb = new Lista[10];

	public ControlerBanco() {
		int tamanho = tb.length;
		for (int i = 0; i < tamanho; i++) {
			tb[i] = new Lista<Conta>();
		}
	}

	private int hash(Conta c) {
		int hash = (c.numero / 1000);
		return hash;
	}

	public void add(Conta conta) throws Exception {
		int hash = hash(conta);
		if (tb[hash].isEmpty()) {
			tb[hash].addFirst(conta);
		} else {
			tb[hash].addLast(conta);
		}

		System.out.println("Cliente: " + conta.nome + " foi adicionado a linha " + hash);
	}

	public void remove(int numero) throws Exception {
		int tamanho = tb.length;
		for (int i = 0; i < tamanho; i++) {
			Lista<Conta> l = tb[i];
			int tamanhoL = l.size();
			for (int j = 0; j < tamanhoL; j++) {
				Conta d = l.get(j);
				if (numero == (d.numero)) {
					l.remove(j);
					System.out.println("Cliente " + d.nome + " da conta " + d.numero + " foi removido!");
				}
			}
		}
	}

	public void search(int numero) throws Exception {
		int tamanho = tb.length;
		int cont = 0;
		for (int i = 0; i < tamanho; i++) {
			Lista<Conta> l = tb[i];
			int tamanhoL = l.size();
			for (int j = 0; j < tamanhoL; j++) {
				Conta d = l.get(j);
				if (numero == d.numero) {
					System.out.println(d);
					cont++;
				}
			}
		}

		if (cont == 0) {
			System.out.println("Conta não localizada");
		}
	}

}
