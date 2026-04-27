package exercicios.inspecao_validacao.startswith_endswith_contains;

import util.Cronometro;

/**
 * Exercicio 04 - startsWith() + endsWith() + contains()
 *
 * Enunciado:
 * Implemente `emailCorporativo` que recebe um email e retorna true se:
 *   - NAO comecar com "admin"
 *   - Terminar com "@empresa.com"
 *   - NAO contiver espacos
 */
public class Exercicio04 {

    public static boolean emailCorporativo(String email) {

        return !email.startsWith("admin")
            && email.endsWith("@empresa.com")
            && !email.contains(" ");
    }

    public static void main(String[] args) {

        // Teste 1 - email corporativo valido -> true
        Cronometro.iniciar();
        boolean r1 = emailCorporativo("rafael@empresa.com");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - comeca com "admin" -> false
        Cronometro.iniciar();
        boolean r2 = emailCorporativo("admin@empresa.com");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - dominio errado -> false
        Cronometro.iniciar();
        boolean r3 = emailCorporativo("rafael@gmail.com");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - contem espaco -> false
        Cronometro.iniciar();
        boolean r4 = emailCorporativo("rafael silva@empresa.com");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - comeca com "admin" mas tem mais chars -> false
        Cronometro.iniciar();
        boolean r5 = emailCorporativo("adminrafael@empresa.com");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5 ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
