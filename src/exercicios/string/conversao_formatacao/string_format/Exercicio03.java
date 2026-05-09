package exercicios.string.conversao_formatacao.string_format;

import java.util.Locale;

/**
 * Exercicio 03 - Preco com duas casas decimais
 *
 * Enunciado:
 * Uma tela de produto precisa exibir:
 * "Produto: Teclado | Preco: R$ 129.90"
 *
 * O preco deve sempre ter duas casas decimais.
 *
 * Implemente o metodo `formatarProduto` usando `String.format(Locale.US, ...)`.
 *
 * Restricoes:
 * - Use `String.format(Locale.US, ...)`.
 * - Use `%s` para o produto.
 * - Use `%.2f` para o preco.
 * - Nao use String.valueOf() para formatar o preco.
 */
public class Exercicio03 {

    public static String formatarProduto(String produto, double preco) {

        return String.format(Locale.US, "Produto: %s | Preco: R$ %.2f", produto, preco);
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
        System.out.println("--- Testes Exercicio 03: formatarProduto ---");

        imprimirTeste(1, "Produto: Teclado | Preco: R$ 129.90", formatarProduto("Teclado", 129.9));
        imprimirTeste(2, "Produto: Mouse | Preco: R$ 59.00", formatarProduto("Mouse", 59));
        imprimirTeste(3, "Produto: Cabo USB | Preco: R$ 0.99", formatarProduto("Cabo USB", 0.99));
        imprimirTeste(4, "Produto: null | Preco: R$ 10.50", formatarProduto(null, 10.5));
        imprimirTeste(5, "Produto: Monitor | Preco: R$ 1000.00", formatarProduto("Monitor", 1000));
    }
}
