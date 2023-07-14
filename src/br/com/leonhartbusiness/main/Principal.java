package br.com.leonhartbusiness.main;

import br.com.leonhartbusiness.models.CartaoCredito;
import br.com.leonhartbusiness.models.Compras;
import br.com.leonhartbusiness.models.Faturamento;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main (String[] args) {

        //Declaração de variáveis
        double limiteCartao = -1; // inicializada para que o while do Limite inicie.
        String itemDescricao;
        double itemValor = -1;
        int opcao = 0; // inicializada para que o while do Menu funcione.
        String erroLimite = """
                VALOR INVÁLIDO!
                Digite o valor do Limite do Cartão de Crédito:""";
        String erroValorCompra = """
                VALOR INVÁLIDO!
                Digite novamente o valor da Compra:""";
        String menuInicial = """
                ===============[SISTEMA DE COMPRAS - LEONHART CARD]===============
                
                1 - Efetuar uma Compra
                2 - Verificar Extrato do Cartão de Crédito
                3 - Sair
                Digite uma das opções acima [1 a 3]""";
        String menuExtrato = """
                ===============[SISTEMA DE COMPRAS - LEONHART CARD]===============
                
                Extrato das Compras:
                """;
        String menuOpcaoInvalida = """
                OPÇÃO INVÁLIDA!
                Verifique as opções disponíveis e tente novamente.
                
                ===============[SISTEMA DE COMPRAS - LEONHART CARD]===============
                
                1 - Efetuar uma Compra
                2 - Verificar Extrato do Cartão de Crédito
                3 - Sair
                Digite uma das opções acima [1 a 3]
                """;
        String menuOpcaoInvalidaInt = """
                OPÇÃO INVÁLIDA!
                Verifique as opções disponíveis e tente novamente.
                """;
        Faturamento operacao = new Faturamento();

        //Processo de criação do Cartão
        System.out.println("Digite o valor do Limite do Cartão de Crédito:");
        Scanner capturaLimite = new Scanner(System.in);

        //Chama o método verificador e cria atribui o Limite ao Cartão criado.
        CartaoCredito cartao = new CartaoCredito(operacao.verificaValor(limiteCartao,capturaLimite,erroLimite));

        //Iniciação do Menu.
        while (opcao != 3) {

            //Gera o menu inicial
            System.out.println(menuInicial);

            //Captura a opção do cliente
            Scanner capturaOpcao = new Scanner(System.in);

            //Verificação se o valor digitado para o Menu é um número válido
            while (!(capturaOpcao.hasNextInt())) {
                System.out.println(menuOpcaoInvalida);
                capturaOpcao = new Scanner(System.in);
            }

            //Atribuição do número válido para opção
            opcao = capturaOpcao.nextInt();

            //Seleção de Opções
            switch (opcao) {

                case 1:

                    //Processo de Tentativa de Compra

                    //Captura da descrição do item
                    System.out.println("Digite o nome do item a ser comprado:");
                    Scanner capturaItem = new Scanner(System.in);
                    itemDescricao = capturaItem.nextLine();

                    //Captura do valor do item
                    System.out.println("Digite o valor da compra:");
                    Scanner capturaValor = new Scanner(System.in);

                    Compras compra = new Compras(itemDescricao, operacao.verificaValor(itemValor,capturaValor,erroValorCompra));

                    //Teste de aprovação da compra.
                    System.out.println(cartao.validaCompra(compra));
                    break;

                case 2:

                    //Ordena lista de compras efetuadas
                    Collections.sort(cartao.getCompras());

                    //Imprime o extrato na tela
                    System.out.println(menuExtrato);
                    if (cartao.getCompras().isEmpty()) {

                        System.out.println("[ Não foram realizadas compras neste período. ]\n");
                        System.out.println(String.format("Limite total do Cartão de Crédito: R$%.2f", cartao.getLimite()));
                        System.out.println(String.format("Saldo no Cartão de Crédito: R$%.2f\n", cartao.getSaldo()));

                    } else {

                        for (Compras c: cartao.getCompras()) {
                            System.out.println("Item Comprado: " + c.getDescricao());
                            System.out.println(String.format("Valor da Compra: R$%.2f", c.getValor()));
                            System.out.println("--------------------------------\n");
                        }
                        System.out.println(String.format("Limite total do Cartão de Crédito: R$%.2f", cartao.getLimite()));
                        System.out.println(String.format("Saldo no Cartão de Crédito: R$%.2f\n", cartao.getSaldo()));

                    }
                    break;

                case 3:
                    System.out.println("Encerrando o Sistema. Até mais!");
                    break;

                default:

                    //Opção para sair sem anda fazer
                    System.out.println(menuOpcaoInvalidaInt);
                    break;
            }
        }
    }
}
