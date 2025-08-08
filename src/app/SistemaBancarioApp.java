package app;

import model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaBancarioApp {

    private static Map<String, Conta> contas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Sistema Bancário ===");
            System.out.println("1. Criar Cliente e Conta Corrente");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir via PIX");
            System.out.println("5. Visualizar Extrato");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarClienteEConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    imprimirExtrato();
                    break;
                case 6:
                    rodando = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarClienteEConta() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();

        ContaCorrente conta = new ContaCorrente(numeroConta, cliente);
        contas.put(numeroConta, conta);

        System.out.println("Cliente e conta criados com sucesso!");
    }

    private static Conta solicitarConta() {
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        Conta conta = contas.get(numero);

        if (conta == null) {
            System.out.println("Conta não encontrada.");
        }
        return conta;
    }

    private static void depositar() {
        Conta conta = solicitarConta();
        if (conta == null) return;

        System.out.print("Valor do depósito: ");
        double valor = Double.parseDouble(scanner.nextLine());
        conta.depositar(valor);
    }

    private static void sacar() {
        Conta conta = solicitarConta();
        if (conta == null) return;

        System.out.print("Valor do saque: ");
        double valor = Double.parseDouble(scanner.nextLine());
        conta.sacar(valor);
    }

    private static void transferir() {
        System.out.print("Conta de origem: ");
        String origemNum = scanner.nextLine();
        System.out.print("Conta de destino: ");
        String destinoNum = scanner.nextLine();

        Conta origem = contas.get(origemNum);
        Conta destino = contas.get(destinoNum);

        if (origem == null || destino == null) {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
            return;
        }

        System.out.print("Valor da transferência: ");
        double valor = Double.parseDouble(scanner.nextLine());

        origem.transferir(destino, valor);
    }

    private static void imprimirExtrato() {
        Conta conta = solicitarConta();
        if (conta == null) return;

        conta.imprimirExtrato();
    }
}
