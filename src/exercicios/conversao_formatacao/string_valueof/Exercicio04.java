package exercicios.conversao_formatacao.string_valueof;

/**
 * Exercicio 04 - Convertendo char[] para String
 *
 * Enunciado:
 * Algumas APIs antigas ou de baixo nivel trabalham com arrays de caracteres.
 * `String.valueOf(char[])` permite transformar esse array em uma String.
 *
 * Implemente o metodo `montarTexto` que recebe um char[] e retorna uma String
 * usando `String.valueOf(letras)`.
 *
 * Regras:
 * 1. Se o array for null, retorne uma string vazia "".
 * 2. Caso contrario, converta usando `String.valueOf(letras)`.
 *
 * Restricoes:
 * - Use `String.valueOf(letras)` no fluxo principal.
 * - Nao use loop.
 * - Nao use new String(letras).
 */
public class Exercicio04 {

    public static String montarTexto(char[] letras) {

        if (letras == null) return "";

        return String.valueOf(letras);
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
        System.out.println("--- Testes Exercicio 04: montarTexto ---");

        imprimirTeste(1, "Java", montarTexto(new char[]{'J', 'a', 'v', 'a'}));
        imprimirTeste(2, "ABC123", montarTexto(new char[]{'A', 'B', 'C', '1', '2', '3'}));
        imprimirTeste(3, "", montarTexto(new char[]{}));
        imprimirTeste(4, "a b", montarTexto(new char[]{'a', ' ', 'b'}));
        imprimirTeste(5, "", montarTexto(null));
    }
}
