package exercicios.string.conversao_formatacao.string_format;

import java.util.Locale;

/**
 * Exercicio 04 - Percentual com caractere %
 *
 * Enunciado:
 * Um painel de produtividade precisa exibir frases como:
 * "Rafael concluiu 8 tarefas (75.5%)"
 *
 * O percentual deve ter uma casa decimal e o caractere de porcentagem deve
 * aparecer no resultado final.
 *
 * Implemente o metodo `formatarProgresso` usando `String.format(Locale.US, ...)`.
 *
 * Restricoes:
 * - Use `String.format(Locale.US, ...)`.
 * - Use `%.1f` para o percentual.
 * - Use `%%` no template para imprimir o caractere `%`.
 * - Nao concatene o caractere `%` fora do format.
 */
public class Exercicio04 {

    public static String formatarProgresso(String nome, int tarefasConcluidas, double percentual) {

        return String.format(Locale.US, "%s concluiu %d tarefas (%.1f%%)", nome, tarefasConcluidas, percentual);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-45s | Obtido: %-45s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04: formatarProgresso ---");

        imprimirTeste(1, "Rafael concluiu 8 tarefas (75.5%)", formatarProgresso("Rafael", 8, 75.5));
        imprimirTeste(2, "Ana concluiu 0 tarefas (0.0%)", formatarProgresso("Ana", 0, 0));
        imprimirTeste(3, "Joao concluiu 12 tarefas (100.0%)", formatarProgresso("Joao", 12, 100));
        imprimirTeste(4, "null concluiu 3 tarefas (33.3%)", formatarProgresso(null, 3, 33.34));
        imprimirTeste(5, "Lia concluiu -1 tarefas (-5.5%)", formatarProgresso("Lia", -1, -5.5));
    }
}
