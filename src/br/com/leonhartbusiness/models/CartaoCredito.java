package br.com.leonhartbusiness.models;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito extends Faturamento {
    private double limite;
    private double saldo;
    private List<Compras> compras;

    public CartaoCredito (double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compras> getCompras() {
        return compras;
    }

    public String validaCompra (Compras tentativaCompra) {

        if (this.getSaldo() >= tentativaCompra.getValor()) {
            this.saldo -= tentativaCompra.getValor();
            this.compras.add(tentativaCompra);
            return "Compra Efetuada com Sucesso!";
        } else {
            return "Compra Negada! Saldo insuficiente.";
        }
    }
}
