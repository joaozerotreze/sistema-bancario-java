package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime timestamp;
    private String descricao;

    public Transacao(TipoTransacao tipo, double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.timestamp = LocalDateTime.now();
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        String dataFormatada = timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return dataFormatada + " - " + tipo + ": R$ " + valor + " - " + descricao;
    }
}
