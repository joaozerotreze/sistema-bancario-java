package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected String numeroConta;
    protected Cliente cliente;
    protected double saldo;
    protected List<Transacao> historico;

    public Conta(String numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        saldo += valor;
        historico.add(new Transacao(TipoTransacao.DEPOSITO, valor, "Depósito efetuado"));
        System.out.println("Depósito realizado com sucesso.");
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }
        if (saldo < valor) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        saldo -= valor;
        historico.add(new Transacao(TipoTransacao.SAQUE, valor, "Saque efetuado"));
        System.out.println("Saque realizado com sucesso.");
        return true;
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            historico.add(new Transacao(TipoTransacao.TRANSFERENCIA, valor,
                    "Transferência para conta " + destino.getNumeroConta()));
            System.out.println("Transferência realizada com sucesso para conta " + destino.getNumeroConta());
            return true;
        }
        return false;
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato da Conta " + numeroConta + " ===");
        System.out.println("Cliente: " + cliente);
        for (Transacao t : historico) {
            System.out.println(t);
        }
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }
}
