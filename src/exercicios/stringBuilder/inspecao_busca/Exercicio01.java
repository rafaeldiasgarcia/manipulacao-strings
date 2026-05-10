package exercicios.stringBuilder.inspecao_busca;

/**
 * Exercicio 01 - Verificando se o builder esta vazio
 *
 * Enunciado:
 * Um sistema recebe um texto opcional e precisa informar se o conteudo montado
 * em um StringBuilder esta vazio ou quantos caracteres ele possui.
 *
 * Implemente o metodo `descreverConteudo` criando um StringBuilder com o texto
 * normalizado e usando os metodos de inspecao do proprio builder.
 *
 * Regras:
 * 1. Se texto for null, trate como "".
 * 2. Se o builder estiver vazio, retorne "vazio".
 * 3. Se o builder nao estiver vazio, retorne "tamanho: N".
 * 4. Espacos contam como caracteres.
 *
 * Restricoes:
 * - Use `new StringBuilder(textoNormalizado)`.
 * - Use `isEmpty()` para verificar se o builder esta vazio.
 * - Use `length()` para obter o tamanho do builder.
 * - Nao use texto.isEmpty().
 * - Nao use texto.length().
 * - Nao use String.format().
 */
public class Exercicio01 {

    public static String descreverConteudo(String texto) {
        // TODO: implemente aqui
        return null;
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
        System.out.println("--- Testes Exercicio 01: descreverConteudo ---");

        imprimirTeste(1, "vazio", descreverConteudo(null));
        imprimirTeste(2, "vazio", descreverConteudo(""));
        imprimirTeste(3, "tamanho: 1", descreverConteudo(" "));
        imprimirTeste(4, "tamanho: 4", descreverConteudo("Java"));
        imprimirTeste(5, "tamanho: 7", descreverConteudo("Java 21"));
    }
}
