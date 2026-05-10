package exercicios.stringBuilder.append;

/**
 * Exercicio 01 - Saudacao simples com append
 *
 * Enunciado:
 * Um sistema precisa montar uma saudacao no formato:
 * "Ola, NOME!"
 *
 * Implemente o metodo `montarSaudacao` usando StringBuilder e append().
 *
 * Regras:
 * 1. Se nome for "Rafael", o retorno deve ser "Ola, Rafael!".
 * 2. Se nome for "", o retorno deve ser "Ola, !".
 * 3. Se nome for null, use "visitante" no lugar do nome.
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `append()` para montar todas as partes do texto.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use concatenacao.
 * - Nao use String.format().
 * - Nao use String.join().
 */
public class Exercicio01 {

    public static String montarSaudacao(String nome) {

        StringBuilder builder = new StringBuilder();

        String textoNormalizado = nome == null ? "visitante" : nome;

        builder.append("Ola, ");
        builder.append(textoNormalizado);
        builder.append("!");

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
        System.out.println("--- Testes Exercicio 01: montarSaudacao ---");

        imprimirTeste(1, "Ola, Rafael!", montarSaudacao("Rafael"));
        imprimirTeste(2, "Ola, Ana!", montarSaudacao("Ana"));
        imprimirTeste(3, "Ola, !", montarSaudacao(""));
        imprimirTeste(4, "Ola, visitante!", montarSaudacao(null));
    }
}
