package exercicios.stringBuilder.append;

/**
 * Exercicio 04 - Repetindo texto com append
 *
 * Enunciado:
 * Um sistema precisa repetir uma palavra varias vezes para gerar uma linha de
 * teste.
 *
 * Implemente o metodo `repetirPalavra` usando StringBuilder, append() e loop.
 *
 * Formato:
 * - repetirPalavra("Java", 3) deve retornar "JavaJavaJava"
 *
 * Regras:
 * 1. Se palavra for "Java" e quantidade 3, retorne "JavaJavaJava".
 * 2. Se quantidade for 0, retorne "".
 * 3. Se quantidade for negativa, retorne "".
 * 4. Se palavra for null, use "" no lugar da palavra.
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `append()` dentro de um loop.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use String.repeat().
 * - Nao use concatenacao.
 * - Nao use String.join().
 */
public class Exercicio04 {

    public static String repetirPalavra(String palavra, int quantidade) {

        StringBuilder builder = new StringBuilder();

        if (quantidade <= 0 || palavra == null) {
            return "";
        }

        String palavraNormalizada = palavra == null ? "" : palavra;

        for (int i = 0; i < quantidade; i++) {
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
        System.out.println("--- Testes Exercicio 04: repetirPalavra ---");

        imprimirTeste(1, "JavaJavaJava", repetirPalavra("Java", 3));
        imprimirTeste(2, "AA", repetirPalavra("A", 2));
        imprimirTeste(3, "", repetirPalavra("Java", 0));
        imprimirTeste(4, "", repetirPalavra("Java", -2));
        imprimirTeste(5, "", repetirPalavra(null, 4));
    }
}
