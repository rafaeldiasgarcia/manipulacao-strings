package exercicios.conversao_formatacao.string_format;

import java.util.Locale;

/**
 * Exercicio 05 - Desafio Final: Recibo formatado
 *
 * Enunciado:
 * Um sistema financeiro precisa gerar um recibo simples em varias linhas.
 *
 * O formato final deve ser:
 *
 * RECIBO #000123
 * Cliente: Rafael
 * Subtotal: R$ 250.50
 * Desconto: 10.0%
 * Pago: true
 *
 * Regras:
 * 1. O id deve aparecer com 6 digitos e zeros a esquerda.
 * 2. O cliente deve ser inserido com `%s`.
 * 3. O subtotal deve ter duas casas decimais.
 * 4. O desconto deve ter uma casa decimal e terminar com `%`.
 * 5. O status pago deve aparecer como true/false.
 * 6. Use `%n` para as quebras de linha.
 *
 * Restricoes:
 * - Use `String.format(Locale.US, ...)`.
 * - Use `%06d` para o id.
 * - Use `%.2f` para o subtotal.
 * - Use `%.1f%%` para o desconto.
 * - Nao use StringBuilder.
 * - Nao use String.join().
 */
public class Exercicio05 {

    public static String gerarRecibo(int id, String cliente, double subtotal, double descontoPercentual, boolean pago) {

        return String.format(
                Locale.US,
                "RECIBO #%06d%n" +
                "Cliente: %s%n" +
                "Subtotal: R$ %.2f%n" +
                "Desconto: %.1f%%%n" +
                "Pago: %s",
                id, cliente, subtotal, descontoPercentual, pago);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %s | Obtido: %s | %s%n",
                numero,
                esperado != null ? esperado.replace("\n", "\\n") : "null",
                obtido != null ? obtido.replace("\n", "\\n") : "null",
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: gerarRecibo ---");

        String quebra = System.lineSeparator();

        imprimirTeste(1,
                "RECIBO #000123" + quebra
                        + "Cliente: Rafael" + quebra
                        + "Subtotal: R$ 250.50" + quebra
                        + "Desconto: 10.0%" + quebra
                        + "Pago: true",
                gerarRecibo(123, "Rafael", 250.5, 10, true));

        imprimirTeste(2,
                "RECIBO #000007" + quebra
                        + "Cliente: Ana" + quebra
                        + "Subtotal: R$ 0.99" + quebra
                        + "Desconto: 0.0%" + quebra
                        + "Pago: false",
                gerarRecibo(7, "Ana", 0.99, 0, false));

        imprimirTeste(3,
                "RECIBO #1000000" + quebra
                        + "Cliente: Empresa X" + quebra
                        + "Subtotal: R$ 1000.00" + quebra
                        + "Desconto: 12.5%" + quebra
                        + "Pago: true",
                gerarRecibo(1000000, "Empresa X", 1000, 12.5, true));

        imprimirTeste(4,
                "RECIBO #000000" + quebra
                        + "Cliente: null" + quebra
                        + "Subtotal: R$ -15.75" + quebra
                        + "Desconto: -3.5%" + quebra
                        + "Pago: false",
                gerarRecibo(0, null, -15.75, -3.5, false));
    }
}
