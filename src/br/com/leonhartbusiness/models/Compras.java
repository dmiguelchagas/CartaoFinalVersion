package br.com.leonhartbusiness.models;

public class Compras extends Faturamento implements Comparable<Compras>{
    private String descricao;
    private double valor;

    public Compras (String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo (Compras outraCompra) {
        //metodo que dá o controle de definir a ordem de prioridade
/*        if (this.getValor() > outraCompra.getValor()) {
            return -1;
        }
        if (this.getValor() < outraCompra.getValor()) {
            return 1;
        }
        return 0;*/

        //metodo simplificado para exibir doubles em ordem do menor para o maior
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
    }
}
