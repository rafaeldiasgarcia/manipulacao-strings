package exercicios.inspecao_validacao.isempty_isblank;

import util.Cronometro;

/**
 * Exercicio 05 - isEmpty() e isBlank() [DESAFIO]
 *
 * Enunciado:
 * Implemente `todosCamposPreenchidos` que recebe varargs de Strings e retorna
 * true somente se TODOS forem nao-nulos e nao-brancos.
 */
public class Exercicio05 {

    public static boolean todosCamposPreenchidos(String... campos) {

        for (String campo : campos) {

            if (campo == null || campo.isBlank()) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        // Teste 1 - todos preenchidos -> true
        Cronometro.iniciar();
        boolean r1 = todosCamposPreenchidos("Rafael", "rafael@email.com", "senha123");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - email vazio -> false
        Cronometro.iniciar();
        boolean r2 = todosCamposPreenchidos("Rafael", "", "senha123");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - email so espacos -> false
        Cronometro.iniciar();
        boolean r3 = todosCamposPreenchidos("Rafael", "   ", "senha123");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - campo null -> false
        Cronometro.iniciar();
        boolean r4 = todosCamposPreenchidos("Rafael", null, "senha123");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - um unico campo preenchido -> true
        Cronometro.iniciar();
        boolean r5 = todosCamposPreenchidos("Ana");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r5,  r5 ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
