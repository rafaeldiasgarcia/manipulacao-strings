package exercicios.conversao_formatacao.string_format;

/**
 * Exercicio 01 - Mensagem simples com String.format()
 *
 * Enunciado:
 * Uma tela precisa exibir uma frase padronizada com nome e idade:
 * "Nome: Rafael | Idade: 30"
 *
 * Implemente o metodo `formatarUsuario` usando `String.format()`.
 *
 * Restricoes:
 * - Use `String.format()`.
 * - Use `%s` para o nome.
 * - Use `%d` para a idade.
 * - Nao monte a mensagem inteira com concatenacao.
 */
public class Exercicio01 {

    public static String formatarUsuario(String nome, int idade) {

        return String.format("Nome: %s | Idade: %d", nome, idade);
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
        System.out.println("--- Testes Exercicio 01: formatarUsuario ---");

        imprimirTeste(1, "Nome: Rafael | Idade: 30", formatarUsuario("Rafael", 30));
        imprimirTeste(2, "Nome: Ana | Idade: 0", formatarUsuario("Ana", 0));
        imprimirTeste(3, "Nome: null | Idade: 18", formatarUsuario(null, 18));
        imprimirTeste(4, "Nome: Joao Silva | Idade: 45", formatarUsuario("Joao Silva", 45));
    }
}
