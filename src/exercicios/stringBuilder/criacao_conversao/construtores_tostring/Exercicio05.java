package exercicios.stringBuilder.criacao_conversao.construtores_tostring;

/**
 * Exercicio 05 - Normalizando texto antes de criar o builder
 *
 * Enunciado:
 * Um relatorio recebe um titulo opcional. Para evitar problemas no restante do
 * sistema, o titulo nunca deve sair como null: quando nao houver titulo, deve
 * sair como uma String vazia.
 *
 * Implemente o metodo `normalizarTitulo` criando um StringBuilder com o titulo
 * normalizado e retornando seu conteudo como String.
 *
 * Regras:
 * 1. Se titulo for "Relatorio", o retorno deve ser "Relatorio".
 * 2. Se titulo for "", o retorno deve ser "".
 * 3. Se titulo for null, o retorno deve ser "".
 * 4. Espacos no inicio e no fim devem ser preservados.
 *
 * Restricoes:
 * - Use `new StringBuilder(textoNormalizado)`.
 * - Use `toString()` para converter o builder de volta para String.
 * - Nao use trim().
 * - Nao use strip().
 * - Nao use String.valueOf().
 */
public class Exercicio05 {

    public static String normalizarTitulo(String titulo) {

        String textoNormalizado = titulo == null ? "" : titulo;

        StringBuilder builder = new StringBuilder(textoNormalizado);

        return builder.toString();

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
        System.out.println("--- Testes Exercicio 05: normalizarTitulo ---");

        imprimirTeste(1, "Relatorio", normalizarTitulo("Relatorio"));
        imprimirTeste(2, "", normalizarTitulo(""));
        imprimirTeste(3, "", normalizarTitulo(null));
        imprimirTeste(4, "  Relatorio  ", normalizarTitulo("  Relatorio  "));
        imprimirTeste(5, " ", normalizarTitulo(" "));
    }
}
