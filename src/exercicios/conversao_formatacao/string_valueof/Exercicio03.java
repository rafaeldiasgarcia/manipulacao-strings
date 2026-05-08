package exercicios.conversao_formatacao.string_valueof;

/**
 * Exercicio 03 - Conversao segura de Object para String
 *
 * Enunciado:
 * Em logs e telas administrativas, nem sempre sabemos se um valor veio
 * preenchido. `String.valueOf(objeto)` e util porque converte null para
 * a string literal "null", sem estourar NullPointerException.
 *
 * Implemente o metodo `converterValorGenerico` que recebe um Object e retorna
 * sua representacao textual usando `String.valueOf()`.
 *
 * Restricoes:
 * - Use `String.valueOf(valor)`.
 * - Nao chame `valor.toString()` diretamente.
 * - Nao trate null manualmente neste exercicio.
 */
public class Exercicio03 {

    public static String converterValorGenerico(Object valor) {

        return String.valueOf(valor);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-20s | Obtido: %-20s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: converterValorGenerico ---");

        imprimirTeste(1, "123", converterValorGenerico(123));
        imprimirTeste(2, "true", converterValorGenerico(true));
        imprimirTeste(3, "Rafael", converterValorGenerico("Rafael"));
        imprimirTeste(4, "19.9", converterValorGenerico(19.9));
        imprimirTeste(5, "null", converterValorGenerico(null));
    }
}
