package exercicios.string.modificacao_limpeza.tolowercase_touppercase;

/**
 * Exercicio 01 - Normalizacao simples com toLowerCase()
 *
 * Enunciado:
 * Em sistemas reais, e-mails costumam ser salvos em minusculas para facilitar
 * comparacoes, buscas e validacoes.
 *
 * Implemente o metodo `normalizarEmail` que recebe um e-mail e retorna esse
 * texto em letras minusculas usando `toLowerCase()`.
 *
 * Restricoes:
 * - Se o e-mail for null, retorne null.
 * - Nao remova espacos.
 * - Nao use replace, replaceAll, equalsIgnoreCase ou regex.
 */
public class Exercicio01 {

    public static String normalizarEmail(String email) {

        if (email == null) return null;

        return email.toLowerCase();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-30s | Obtido: %-30s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 01: normalizarEmail ---");

        imprimirTeste(1, "rafael@email.com", normalizarEmail("RAFAEL@EMAIL.COM"));
        imprimirTeste(2, "suporte@empresa.com.br", normalizarEmail("Suporte@Empresa.COM.BR"));
        imprimirTeste(3, "admin", normalizarEmail("admin"));
        imprimirTeste(4, "", normalizarEmail(""));
        imprimirTeste(5, null, normalizarEmail(null));
        imprimirTeste(6, " usuario@teste.com ", normalizarEmail(" Usuario@Teste.COM "));
    }
}
