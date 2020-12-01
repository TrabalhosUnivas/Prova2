package edu.univas.main;


import java.util.Scanner;

import edu.univas.conta.Conta;

public class Start{
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Conta[] contas = new Conta[100];
		String oper;
		do {
			menu();
			oper = sc.nextLine();
			if (oper.equals("1")) {
				cadastrarConta(contas);
			} else if (oper.equals("2")) {
				verSaldo(contas);
			} else if (oper.equals("3")) {
				break;
			} else {

			}
		} while (true);
		sc.close();
	}

	public static void cadastrarConta(Conta[] contas) {
		int i = 0;
		do {
			if (contas[i] == null) {
				Conta conta = new Conta();
				System.out.println("Digite a descrição da conta: ");
				conta.desc = sc.nextLine();
				System.out.println("Digite o valor: ");
				conta.valor = sc.nextFloat();
				sc.nextLine();
				System.out.println("Digite a data de vencimento: ");
				conta.data = sc.nextLine();
				System.out.println("Digite o tipo: Despesa ou Receita.");
				conta.tipo = sc.nextLine();
				contas[i] = conta;
				break;
			}
			i++;
		} while (true);
	}

	public static void verSaldo(Conta[] contas) {
		float receita = 0;
		float despesa = 0;
		for (int i = 0; i < 100; i++) {
			if (contas[i] != null) {
				Conta conta = contas[i];
				if (conta.tipo.equals("Despesa")) {
					despesa = conta.valor + despesa;
				} else if (conta.tipo.equals("Receita")) {
					receita = conta.valor + receita;
				} else {

				}
			}
		}
		float saldo = receita - despesa;
		if (saldo > 0) {
			System.out.printf("\n Saldo +: %.2f %n", saldo);
		} else if (saldo < 0) {
			System.out.printf("\n Saldo -: %.2f %n", saldo);
		} else {
			System.out.println("\n Sem Saldo");
		}
	}

	public static void menu() {
		System.out.println("1. Cadastro de conta");
		System.out.println("2. Ver Saldo ");
		System.out.println("3. Sair");
	}
}