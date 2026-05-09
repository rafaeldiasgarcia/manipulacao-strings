package exercicios.string.conversao_formatacao.string_join;

/**
 * Exercicio 02 - Montando data simples
 *
 * Enunciado:
 * Um sistema recebe ano, mes e dia ja como texto e precisa montar uma data
 * no formato "AAAA-MM-DD".
 *
 * Implemente o metodo `montarData` usando `String.join()`.
 *
 * Restricoes:
 * - Use `String.join("-", ano, mes, dia)`.
 * - Nao use concatenacao para inserir os hifens.
 * - Nao use String.format().
 */
public class Exercicio02 {

    public static String montarData(String ano, String mes, String dia) {

        return String.join("-", ano, mes, dia);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-15s | Obtido: %-15s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: montarData ---");

        imprimirTeste(1, "2026-05-08", montarData("2026", "05", "08"));
        imprimirTeste(2, "1999-12-31", montarData("1999", "12", "31"));
        imprimirTeste(3, "2026-1-5", montarData("2026", "1", "5"));
        imprimirTeste(4, "null-05-08", montarData(null, "05", "08"));
        imprimirTeste(5, "2026--08", montarData("2026", "", "08"));
    }
}
