package exercicios.inspecao_validacao.length;

/**
 * Exercicio 02 - length()
 *
 * Enunciado:
 * Implemente `senhaValida` que recebe uma String senha e retorna
 * true se ela tiver pelo menos 8 caracteres, false caso contrario.
 *
 * Restricao: use apenas length(). Sem loops.
 */
public class Exercicio02 {

    public static boolean senhaValida(String senha) {

        return senha.length() >= 8;
    }

    public static void main(String[] args) {

        // Teste 1 - exatamente 8 chars (limite minimo) -> valida
        boolean r1 = senhaValida("12345678");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1  ? "PASSOU" : "FALHOU");

        // Teste 2 - 7 chars, abaixo do minimo -> invalida
        boolean r2 = senhaValida("1234567");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2  ? "PASSOU" : "FALHOU");

        // Teste 3 - senha longa, bem acima do minimo -> valida
        boolean r3 = senhaValida("minhaSenhaForte2024");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r3,  r3  ? "PASSOU" : "FALHOU");

        // Teste 4 - string vazia -> invalida
        boolean r4 = senhaValida("");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4  ? "PASSOU" : "FALHOU");

        // Teste 5 - 1 char -> invalida
        boolean r5 = senhaValida("x");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5  ? "PASSOU" : "FALHOU");
    }
}
