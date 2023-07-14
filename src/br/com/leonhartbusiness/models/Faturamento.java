package br.com.leonhartbusiness.models;

import br.com.leonhartbusiness.methods.Verificavel;
import java.util.Scanner;

public class Faturamento implements Verificavel {

    @Override
    public double verificaValor(double chave, Scanner captura, String mensagemErro) {
        while (chave < 0) {
            if (captura.hasNextDouble()) {
                chave = captura.nextDouble();
                if (chave < 0) {
                    System.out.println(mensagemErro);
                    captura = new Scanner(System.in);
                }
            } else {
                System.out.println(mensagemErro);
                captura = new Scanner(System.in);
            }
        }
        return chave;
    }
}
