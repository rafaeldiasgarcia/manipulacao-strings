package exercicios.stringBuilder.criacao_conversao;

/**
 * Exercicio 02 - Criando um builder vazio
 *
 * Enunciado:
 * Um sistema precisa iniciar uma area de montagem de texto vazia para preencher
 * depois. Neste exercicio, voce deve apenas criar o StringBuilder vazio e
 * retornar seu conteudo convertido para String.
 *
 * Implemente o metodo `criarTextoVazio`.
 *
 * Regras:
 * 1. O retorno deve ser uma String vazia "".
 * 2. O metodo nao recebe parametros.
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `toString()` para converter o builder de volta para String.
 * - Nao retorne "" diretamente.
 * - Nao use concatenacao.
 */
public class Exercicio02 {

    public static String criarTextoVazio() {

        StringBuilder builder = new StringBuilder();

        return builder.toString();
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
        System.out.println("--- Testes Exercicio 02: criarTextoVazio ---");

        imprimirTeste(1, "", criarTextoVazio());
    }
}
