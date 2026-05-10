package exercicios.stringBuilder.append;

/**
 * Exercicio 03 - Mensagem com trecho opcional
 *
 * Enunciado:
 * Um sistema precisa montar uma mensagem de boas-vindas. Se o usuario for
 * administrador, a mensagem deve incluir um aviso extra.
 *
 * Formatos:
 * - Usuario comum: "Bem-vindo, NOME."
 * - Administrador: "Bem-vindo, NOME. Acesso administrativo liberado."
 *
 * Implemente o metodo `montarMensagemAcesso` usando StringBuilder e append().
 *
 * Regras:
 * 1. Se nome for "Ana" e administrador false, retorne:
 *    "Bem-vindo, Ana."
 * 2. Se nome for "Rafael" e administrador true, retorne:
 *    "Bem-vindo, Rafael. Acesso administrativo liberado."
 * 3. Se nome for null, use "visitante".
 * 4. Se nome for "", preserve o nome vazio.
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `append()` para montar todas as partes do texto.
 * - Use `if` para adicionar o trecho administrativo somente quando necessario.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use concatenacao.
 * - Nao use String.format().
 */
public class Exercicio03 {

    public static String montarMensagemAcesso(String nome, boolean administrador) {

        StringBuilder builder = new StringBuilder();

        String nomeNormalizado = nome == null ? "visitante" : nome;

        builder.append("Bem-vindo, ");
        builder.append(nomeNormalizado);
        builder.append(".");

        if (administrador) {
            builder.append(" Acesso administrativo liberado.");
        }

        return builder.toString();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-70s | Obtido: %-70s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: montarMensagemAcesso ---");

        imprimirTeste(1,
                "Bem-vindo, Ana.",
                montarMensagemAcesso("Ana", false));

        imprimirTeste(2,
                "Bem-vindo, Rafael. Acesso administrativo liberado.",
                montarMensagemAcesso("Rafael", true));

        imprimirTeste(3,
                "Bem-vindo, visitante.",
                montarMensagemAcesso(null, false));

        imprimirTeste(4,
                "Bem-vindo, visitante. Acesso administrativo liberado.",
                montarMensagemAcesso(null, true));

        imprimirTeste(5,
                "Bem-vindo, .",
                montarMensagemAcesso("", false));
    }
}
