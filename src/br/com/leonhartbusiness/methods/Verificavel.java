package br.com.leonhartbusiness.methods;

import br.com.leonhartbusiness.models.Faturamento;
import java.util.Scanner;

public interface Verificavel {
    public double verificaValor(double chave, Scanner captura, String mensagemErro);
}
