package exercicios.isempty_isblank;

/**
 * Exercicio 05 — isEmpty() e isBlank() [DESAFIO]
 *
 * Enunciado:
 * Implemente `todosCamposPreenchidos` que recebe um número variável de Strings
 * (varargs) e retorna true somente se TODOS forem não-nulos e não-brancos.
 * Qualquer campo nulo, vazio ou só espaços deve retornar false imediatamente.
 *
 * Assinatura: public static boolean todosCamposPreenchidos(String... campos)
 *
 * Dica: varargs é tratado como array dentro do método.
 */
public class Exercicio05 {

    public static boolean todosCamposPreenchidos(String... campos) {

        for (String campo : campos) {

            if (campo == null || campo.isBlank()) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        boolean r1 = todosCamposPreenchidos("Rafael", "rafael@email.com", "senha123");
        boolean r2 = todosCamposPreenchidos("Rafael", "", "senha123");
        boolean r3 = todosCamposPreenchidos("Rafael", "   ", "senha123");
        boolean r4 = todosCamposPreenchidos("Rafael", null, "senha123");
        boolean r5 = todosCamposPreenchidos("Ana");

        // Teste 1 — todos preenchidos → true
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 — email vazio → false
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 — email só espaços → false
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");

        // Teste 4 — campo null → false
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 — um único campo preenchido → true
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r5,  r5 ? "PASSOU" : "FALHOU");
    }
}
