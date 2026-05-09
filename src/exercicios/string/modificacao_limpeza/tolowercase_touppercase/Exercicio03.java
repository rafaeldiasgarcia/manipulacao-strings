package exercicios.string.modificacao_limpeza.tolowercase_touppercase;

/**
 * Exercicio 03 - Normalizacao de status com toLowerCase()
 *
 * Enunciado:
 * Imagine que uma API externa envia status de pagamento com letras misturadas:
 * "PAGO", "Pago", "pEnDeNtE", "CANCELADO".
 *
 * Para facilitar comparacoes internas, queremos normalizar o status para
 * minusculas antes de devolver o valor para o restante do sistema.
 *
 * Implemente o metodo `normalizarStatus` que:
 * 1. Se o status for null, retorne "desconhecido".
 * 2. Se o status for vazio ou apenas espacos, retorne "desconhecido".
 * 3. Caso contrario, limpe as bordas com `strip()` e retorne em minusculas com `toLowerCase()`.
 *
 * Restricoes:
 * - Use `toLowerCase()` no fluxo principal.
 * - Use `strip()` para limpar apenas as bordas.
 * - Nao use replace, replaceAll, equalsIgnoreCase ou regex.
 */
public class Exercicio03 {

    public static String normalizarStatus(String status) {

        if (status == null || status.isBlank()) return "desconhecido";

        return status
                .strip()
                .toLowerCase();
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
        System.out.println("--- Testes Exercicio 03: normalizarStatus ---");

        imprimirTeste(1, "pago", normalizarStatus("PAGO"));
        imprimirTeste(2, "pendente", normalizarStatus("  pEnDeNtE  "));
        imprimirTeste(3, "cancelado", normalizarStatus("\tCANCELADO\n"));
        imprimirTeste(4, "aguardando confirmacao", normalizarStatus("Aguardando Confirmacao"));
        imprimirTeste(5, "desconhecido", normalizarStatus(""));
        imprimirTeste(6, "desconhecido", normalizarStatus("    "));
        imprimirTeste(7, "desconhecido", normalizarStatus(null));
        imprimirTeste(8, "em analise manual", normalizarStatus(" Em Analise Manual "));
    }
}
