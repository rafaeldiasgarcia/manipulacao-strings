package exercicios.conversao_formatacao.string_valueof;

/**
 * Exercicio 01 - Convertendo numero inteiro para String
 *
 * Enunciado:
 * Em muitas aplicacoes, IDs numericos precisam virar texto para serem exibidos
 * em telas, logs ou mensagens.
 *
 * Implemente o metodo `converterIdParaTexto` que recebe um int e retorna esse
 * valor convertido para String usando `String.valueOf()`.
 *
 * Restricoes:
 * - Use `String.valueOf(id)`.
 * - Nao use concatenacao com string vazia.
 * - Nao use Integer.toString().
 */
public class Exercicio01 {

    public static String converterIdParaTexto(int id) {

        return String.valueOf(id);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-15s | Obtido: %-15s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 01: converterIdParaTexto ---");

        imprimirTeste(1, "10", converterIdParaTexto(10));
        imprimirTeste(2, "0", converterIdParaTexto(0));
        imprimirTeste(3, "-5", converterIdParaTexto(-5));
        imprimirTeste(4, "2147483647", converterIdParaTexto(Integer.MAX_VALUE));
        imprimirTeste(5, "-2147483648", converterIdParaTexto(Integer.MIN_VALUE));
    }
}
