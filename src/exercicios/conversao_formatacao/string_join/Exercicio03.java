package exercicios.conversao_formatacao.string_join;

import java.util.List;

/**
 * Exercicio 03 - Juntando uma lista de tags
 *
 * Enunciado:
 * Uma tela precisa exibir tags separadas por virgula e espaco:
 * "java, strings, backend"
 *
 * Implemente o metodo `juntarTags` usando `String.join()` com uma lista.
 *
 * Regras:
 * 1. Se a lista for null, retorne uma string vazia "".
 * 2. Caso contrario, junte os elementos com ", ".
 *
 * Restricoes:
 * - Use `String.join(", ", tags)` no fluxo principal.
 * - Nao use loop.
 * - Nao use StringBuilder.
 */
public class Exercicio03 {

    public static String juntarTags(List<String> tags) {

        if (tags == null) {
            return "";
        }

        return String.join(", ", tags);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-30s | Obtido: %-30s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: juntarTags ---");

        imprimirTeste(1, "java, strings, backend", juntarTags(List.of("java", "strings", "backend")));
        imprimirTeste(2, "api", juntarTags(List.of("api")));
        imprimirTeste(3, "", juntarTags(List.of()));
        imprimirTeste(4, "", juntarTags(null));
        imprimirTeste(5, "admin, user, report", juntarTags(List.of("admin", "user", "report")));
    }
}
