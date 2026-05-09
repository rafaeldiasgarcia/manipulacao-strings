package exercicios.string.conversao_formatacao.string_join;

/**
 * Exercicio 01 - Juntando nome completo
 *
 * Enunciado:
 * Um cadastro precisa exibir o nome completo juntando primeiro nome e sobrenome
 * com um espaco entre eles.
 *
 * Implemente o metodo `montarNomeCompleto` usando `String.join()`.
 *
 * Restricoes:
 * - Use `String.join(" ", primeiroNome, sobrenome)`.
 * - Nao use concatenacao para juntar os nomes.
 * - Nao use String.format().
 */
public class Exercicio01 {

    public static String montarNomeCompleto(String primeiroNome, String sobrenome) {

        return String.join(" ", primeiroNome, sobrenome);
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
        System.out.println("--- Testes Exercicio 01: montarNomeCompleto ---");

        imprimirTeste(1, "Rafael Garcia", montarNomeCompleto("Rafael", "Garcia"));
        imprimirTeste(2, "Ana Silva", montarNomeCompleto("Ana", "Silva"));
        imprimirTeste(3, "Joao ", montarNomeCompleto("Joao", ""));
        imprimirTeste(4, " null", montarNomeCompleto("", null));
        imprimirTeste(5, "null Souza", montarNomeCompleto(null, "Souza"));
    }
}
