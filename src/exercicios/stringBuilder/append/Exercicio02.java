package exercicios.stringBuilder.append;

/**
 * Exercicio 02 - Montando resumo com tipos diferentes
 *
 * Enunciado:
 * Um sistema precisa montar uma linha de resumo de usuario no formato:
 * "Usuario: NOME | Idade: IDADE | Ativo: ATIVO"
 *
 * Implemente o metodo `montarResumoUsuario` usando StringBuilder e append().
 *
 * Regras:
 * 1. Se nome for "Ana", idade 30 e ativo true, retorne:
 *    "Usuario: Ana | Idade: 30 | Ativo: true"
 * 2. Se nome for "", preserve o texto vazio no lugar do nome.
 * 3. Se nome for null, use "sem nome".
 * 4. O valor boolean deve aparecer como "true" ou "false".
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `append()` para adicionar textos, int e boolean.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use concatenacao.
 * - Nao use String.format().
 * - Nao use String.valueOf().
 */
public class Exercicio02 {

    public static String montarResumoUsuario(String nome, int idade, boolean ativo) {

        StringBuilder builder = new StringBuilder();

        String nomeNormalizado = nome == null ? "sem nome" : nome;

        builder.append("Usuario: ");
        builder.append(nomeNormalizado);
        builder.append(" | ");
        builder.append("Idade: ");
        builder.append(idade);
        builder.append(" | ");
        builder.append("Ativo: ");
        builder.append(ativo);

        return builder.toString();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-55s | Obtido: %-55s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: montarResumoUsuario ---");

        imprimirTeste(1,
                "Usuario: Ana | Idade: 30 | Ativo: true",
                montarResumoUsuario("Ana", 30, true));

        imprimirTeste(2,
                "Usuario: Rafael | Idade: 41 | Ativo: false",
                montarResumoUsuario("Rafael", 41, false));

        imprimirTeste(3,
                "Usuario:  | Idade: 0 | Ativo: true",
                montarResumoUsuario("", 0, true));

        imprimirTeste(4,
                "Usuario: sem nome | Idade: 25 | Ativo: false",
                montarResumoUsuario(null, 25, false));
    }
}
