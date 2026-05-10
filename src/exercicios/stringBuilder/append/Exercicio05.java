package exercicios.stringBuilder.append;

/**
 * Exercicio 05 - Lista com separador
 *
 * Enunciado:
 * Um sistema precisa montar uma lista de palavras separadas por virgula e
 * espaco, sem deixar separador sobrando no final.
 *
 * Implemente o metodo `juntarComVirgula` usando StringBuilder e append().
 *
 * Formato:
 * - {"Java", "SQL", "Git"} deve retornar "Java, SQL, Git"
 *
 * Regras:
 * 1. Se palavras for {"Java", "SQL", "Git"}, retorne "Java, SQL, Git".
 * 2. Se palavras tiver apenas um item, retorne apenas esse item.
 * 3. Se palavras for vazio, retorne "".
 * 4. Se palavras for null, retorne "".
 * 5. Se algum item for null, use "" no lugar dele.
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `append()` dentro de um loop.
 * - Use `if` para controlar quando adicionar o separador.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use String.join().
 * - Nao use String.format().
 * - Nao use concatenacao.
 */
public class Exercicio05 {

    public static String juntarComVirgula(String[] palavras) {

        StringBuilder builder = new StringBuilder();

        if (palavras == null || palavras.length < 1) {
            return "";
        }

        String palavraNormalizada = palavras[0] == null ? "" : palavras[0];
        builder.append(palavraNormalizada);

        for (int i = 1; i < palavras.length; i++) {

            palavraNormalizada = palavras[i] == null ? "" : palavras[i];

            builder.append(", ");
            builder.append(palavraNormalizada);
        }

        return builder.toString();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-35s | Obtido: %-35s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: juntarComVirgula ---");

        imprimirTeste(1, "Java, SQL, Git", juntarComVirgula(new String[]{"Java", "SQL", "Git"}));
        imprimirTeste(2, "Java", juntarComVirgula(new String[]{"Java"}));
        imprimirTeste(3, "", juntarComVirgula(new String[]{}));
        imprimirTeste(4, "", juntarComVirgula(null));
        imprimirTeste(5, "Java, , Git", juntarComVirgula(new String[]{"Java", null, "Git"}));
        imprimirTeste(6, ", Java", juntarComVirgula(new String[]{null, "Java"}));
    }
}
