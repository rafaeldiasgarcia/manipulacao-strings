package exercicios.string.conversao_formatacao.string_format;

/**
 * Exercicio 02 - Codigo com zeros a esquerda
 *
 * Enunciado:
 * Um sistema de pedidos precisa exibir numeros no formato:
 * "PED-0007"
 *
 * O numero deve ter 4 digitos, completando com zeros a esquerda quando necessario.
 *
 * Implemente o metodo `formatarPedido` usando `String.format()`.
 *
 * Restricoes:
 * - Use `String.format()`.
 * - Use `%04d` para formatar o numero com 4 digitos.
 * - Nao use if para adicionar zeros manualmente.
 * - Nao use substring.
 */
public class Exercicio02 {

    public static String formatarPedido(int numero) {

        return String.format("PED-%04d", numero);
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
        System.out.println("--- Testes Exercicio 02: formatarPedido ---");

        imprimirTeste(1, "PED-0007", formatarPedido(7));
        imprimirTeste(2, "PED-0042", formatarPedido(42));
        imprimirTeste(3, "PED-0000", formatarPedido(0));
        imprimirTeste(4, "PED-1234", formatarPedido(1234));
        imprimirTeste(5, "PED-12345", formatarPedido(12345));
    }
}
