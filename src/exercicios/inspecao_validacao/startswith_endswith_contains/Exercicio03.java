package exercicios.inspecao_validacao.startswith_endswith_contains;

import util.Cronometro;

/**
 * Exercicio 03 - contains()
 *
 * Enunciado:
 * Implemente `logContemErro` que recebe uma linha de log e retorna true
 * se ela contiver a palavra "ERROR" ou "FATAL" (case-sensitive).
 */
public class Exercicio03 {

    public static boolean logContemErro(String log) {

        return log.contains("ERROR")
            || log.contains("FATAL");
    }

    public static void main(String[] args) {

        // Teste 1 - contem ERROR -> true
        Cronometro.iniciar();
        boolean r1 = logContemErro("[ERROR] Conexao recusada");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - contem FATAL -> true
        Cronometro.iniciar();
        boolean r2 = logContemErro("[FATAL] Falha critica no sistema");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r2,  r2 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - INFO, sem erro -> false
        Cronometro.iniciar();
        boolean r3 = logContemErro("[INFO] Servidor iniciado com sucesso");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - WARN, sem erro -> false
        Cronometro.iniciar();
        boolean r4 = logContemErro("[WARN] Memoria acima de 80%");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - "error" minusculo -> false (case-sensitive)
        Cronometro.iniciar();
        boolean r5 = logContemErro("[error] disco cheio");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5 ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
