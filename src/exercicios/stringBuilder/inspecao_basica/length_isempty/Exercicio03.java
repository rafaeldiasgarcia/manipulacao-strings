package exercicios.stringBuilder.inspecao_basica.length_isempty;

/**
 * Exercicio 03 - Mensagem com campos opcionais
 *
 * Enunciado:
 * Um sistema precisa montar uma mensagem com nome e email, mas ambos os campos
 * sao opcionais. Campos nulos ou vazios devem ser ignorados.
 *
 * Formatos:
 * - Nome: "Nome: Rafael"
 * - Email: "Email: rafael@email.com"
 * - Nome e email: "Nome: Rafael | Email: rafael@email.com"
 * - Nenhum campo valido: "sem dados"
 *
 * Implemente o metodo `montarContato` usando StringBuilder.
 *
 * Regras:
 * 1. Se nome e email forem validos, separe os dois com " | ".
 * 2. Se apenas nome for valido, retorne apenas o nome formatado.
 * 3. Se apenas email for valido, retorne apenas o email formatado.
 * 4. Se nenhum campo for valido, retorne "sem dados".
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `length()` para decidir se deve adicionar o separador.
 * - Use `isEmpty()` para decidir se deve retornar "sem dados".
 * - Use `append()` para montar o texto.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use String.format().
 * - Nao use String.join().
 */
public class Exercicio03 {

    public static String montarContato(String nome, String email) {

        StringBuilder builder = new StringBuilder();

        if (nome != null && !nome.isEmpty()) {
            if (builder.length() > 0) {
                builder.append(" | ");
            }

            builder.append("Nome: ");
            builder.append(nome);

        }
        if (email != null && !email.isEmpty()) {
            if (builder.length() > 0) {
                builder.append(" | ");
            }

            builder.append("Email: ");
            builder.append(email);

        }
        if (builder.isEmpty()) {
            return "sem dados";
        }

        return builder.toString();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-45s | Obtido: %-45s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: montarContato ---");

        imprimirTeste(1,
                "Nome: Rafael | Email: rafael@email.com",
                montarContato("Rafael", "rafael@email.com"));

        imprimirTeste(2,
                "Nome: Ana",
                montarContato("Ana", null));

        imprimirTeste(3,
                "Email: contato@email.com",
                montarContato("", "contato@email.com"));

        imprimirTeste(4,
                "sem dados",
                montarContato(null, ""));

        imprimirTeste(5,
                "sem dados",
                montarContato("", null));
    }
}
