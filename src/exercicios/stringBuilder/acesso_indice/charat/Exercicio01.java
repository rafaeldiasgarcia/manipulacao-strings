package exercicios.stringBuilder.acesso_indice.charat;

/**
 * Exercicio 01 - Primeiro caractere com charAt
 *
 * Enunciado:
 * Um sistema precisa descobrir o primeiro caractere de um texto depois de
 * coloca-lo em um StringBuilder.
 *
 * Implemente o metodo `obterPrimeiroCaractere` usando StringBuilder e charAt().
 *
 * Regras:
 * 1. Se texto for "Java", retorne 'J'.
 * 2. Se texto for "abc", retorne 'a'.
 * 3. Se texto for "", retorne '?'.
 * 4. Se texto for null, retorne '?'.
 * 5. Espaco tambem conta como caractere.
 *
 * Restricoes:
 * - Use `new StringBuilder(textoNormalizado)`.
 * - Use `isEmpty()` para verificar se o builder esta vazio.
 * - Use `charAt(0)` para obter o primeiro caractere.
 * - Nao use texto.charAt().
 * - Nao use texto.isEmpty().
 */
public class Exercicio01 {

    public static char obterPrimeiroCaractere(String texto) {
        // TODO: implemente aqui
        return '?';
    }

    private static void imprimirTeste(int numero, char esperado, char obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == obtido;

        System.out.printf(
                "Teste %d | Esperado: %-5s | Obtido: %-5s | %s%n",
                numero,
                esperado,
                obtido,
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 01: obterPrimeiroCaractere ---");

        imprimirTeste(1, 'J', obterPrimeiroCaractere("Java"));
        imprimirTeste(2, 'a', obterPrimeiroCaractere("abc"));
        imprimirTeste(3, '?', obterPrimeiroCaractere(""));
        imprimirTeste(4, '?', obterPrimeiroCaractere(null));
        imprimirTeste(5, ' ', obterPrimeiroCaractere(" Java"));
    }
}
