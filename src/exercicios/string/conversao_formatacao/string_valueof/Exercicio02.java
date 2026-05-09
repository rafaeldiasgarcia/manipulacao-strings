package exercicios.string.conversao_formatacao.string_valueof;

/**
 * Exercicio 02 - Convertendo boolean para texto de status
 *
 * Enunciado:
 * Um sistema de configuracoes precisa gerar uma linha simples no formato:
 * "notificacoes=true" ou "notificacoes=false".
 *
 * Implemente o metodo `gerarLinhaConfiguracao` que recebe um boolean e retorna
 * a linha usando `String.valueOf()` para converter o valor booleano.
 *
 * Restricoes:
 * - Use `String.valueOf(ativo)` para converter o boolean.
 * - Nao use operador ternario para transformar true/false manualmente.
 * - Nao use Boolean.toString().
 */
public class Exercicio02 {

    public static String gerarLinhaConfiguracao(boolean ativo) {

        return "notificacoes=" + String.valueOf(ativo);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-25s | Obtido: %-25s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: gerarLinhaConfiguracao ---");

        imprimirTeste(1, "notificacoes=true", gerarLinhaConfiguracao(true));
        imprimirTeste(2, "notificacoes=false", gerarLinhaConfiguracao(false));
    }
}
