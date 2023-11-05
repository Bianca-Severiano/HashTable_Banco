package view;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import controller.ControlerBanco;
import model.Conta;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, HeadlessException, Exception {

		ControlerBanco c = new ControlerBanco();
		int r = 0;

		do {
			r = Integer.parseInt(JOptionPane
					.showInputDialog("1 - Adicionar Conta\n2 - Pesquisar Conta \n3 - Remover Conta\n9 - Sair"));

			switch (r) {
			case 1: { // Adiciona
				Conta conta = new Conta();
				int cont = 0;
				do {
					conta.numero = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta"));
					if (conta.numero < 9999) {
						conta.nome = JOptionPane.showInputDialog("Insira o nome cliente");
						conta.saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo em conta: R$"));

						c.add(conta);
						cont++;
					} else {
						JOptionPane.showMessageDialog(null, "Número de conta inválido!");
					}
				} while (cont == 0);
				break;
			}
			case 2: { // Pesquisa
				c.search(Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta para procurá-la")));
				break;

			}

			case 3: { // Remove
				c.remove(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta para removê-la")));
				break;
			}

			case 9: { // Sai
				System.err.println("Saindo...");
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + r);
			}

		} while (r != 9);

	}

}
