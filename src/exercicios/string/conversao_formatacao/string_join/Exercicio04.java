package exercicios.string.conversao_formatacao.string_join;

/**
 * Exercicio 04 - Montando caminho de recurso
 *
 * Enunciado:
 * Uma API precisa montar caminhos logicos no formato:
 * "usuarios/123/perfil"
 *
 * Implemente o metodo `montarCaminhoRecurso` usando `String.join()`.
 *
 * Regras:
 * 1. Se usuarioId for null, use "anonimo".
 * 2. Se recurso for null, use "resumo".
 * 3. O caminho deve sempre comecar com "usuarios".
 *
 * Restricoes:
 * - Use `String.join("/", ...)`.
 * - Nao use concatenacao para inserir barras.
 * - Nao use String.format().
 */
public class Exercicio04 {

    public static String montarCaminhoRecurso(String usuarioId, String recurso) {

        if (usuarioId == null) {
            usuarioId = "anonimo";
        }
        if (recurso == null) {
            recurso = "resumo";
        }

        return String.join("/", "usuarios", usuarioId, recurso);
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
        System.out.println("--- Testes Exercicio 04: montarCaminhoRecurso ---");

        imprimirTeste(1, "usuarios/123/perfil", montarCaminhoRecurso("123", "perfil"));
        imprimirTeste(2, "usuarios/456/pedidos", montarCaminhoRecurso("456", "pedidos"));
        imprimirTeste(3, "usuarios/anonimo/perfil", montarCaminhoRecurso(null, "perfil"));
        imprimirTeste(4, "usuarios/123/resumo", montarCaminhoRecurso("123", null));
        imprimirTeste(5, "usuarios/anonimo/resumo", montarCaminhoRecurso(null, null));
        imprimirTeste(6, "usuarios//perfil", montarCaminhoRecurso("", "perfil"));
    }
}
