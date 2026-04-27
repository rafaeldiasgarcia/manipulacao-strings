package exercicios.inspecao_validacao.isempty_isblank;

import util.Cronometro;

/**
 * Exercicio 04 - isEmpty() e isBlank()
 *
 * Enunciado:
 * Implemente `primeiroCampoPreenchido` que recebe um array de Strings e
 * retorna a primeira string que nao seja nula, vazia ou so espacos.
 * Se nao encontrar nenhuma, retorne null.
 */
public class Exercicio04 {

    public static String primeiroCampoPreenchido(String[] campos) {

        for (String campo : campos) {

            if (campo != null && !campo.isBlank()) return campo;
        }

        return null;
    }

    public static void main(String[] args) {

        // Teste 1 - tres invalidos antes -> retorna "Rafael"
        Cronometro.iniciar();
        String r1 = primeiroCampoPreenchido(new String[]{null, "", "  ", "Rafael", "Java"});
        System.out.printf("Teste 1 | Esperado: %-8s | Obtido: %-8s | %s%n", "Rafael", r1, "Rafael".equals(r1) ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - todos invalidos -> null
        Cronometro.iniciar();
        String r2 = primeiroCampoPreenchido(new String[]{"", "   ", null});
        System.out.printf("Teste 2 | Esperado: %-8s | Obtido: %-8s | %s%n", "null", r2, r2 == null ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - primeiro ja e valido -> "Java"
        Cronometro.iniciar();
        String r3 = primeiroCampoPreenchido(new String[]{"Java", "Python"});
        System.out.printf("Teste 3 | Esperado: %-8s | Obtido: %-8s | %s%n", "Java", r3, "Java".equals(r3) ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - array vazio -> null
        Cronometro.iniciar();
        String r4 = primeiroCampoPreenchido(new String[]{});
        System.out.printf("Teste 4 | Esperado: %-8s | Obtido: %-8s | %s%n", "null", r4, r4 == null ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - null e branco antes -> retorna "ok"
        Cronometro.iniciar();
        String r5 = primeiroCampoPreenchido(new String[]{null, "  ", "ok"});
        System.out.printf("Teste 5 | Esperado: %-8s | Obtido: %-8s | %s%n", "ok", r5, "ok".equals(r5) ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
