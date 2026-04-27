package exercicios.inspecao_validacao.startswith_endswith_contains;

/**
 * Exercicio 05 - startsWith() + endsWith() + contains() [DESAFIO]
 *
 * Enunciado:
 * Implemente `validarSqlSeguro` que retorna true somente se a query:
 *   - Comecar com "SELECT"
 *   - NAO contiver "DROP"
 *   - NAO contiver "DELETE"
 *   - NAO contiver "--"
 *   - Terminar com ";"
 */
public class Exercicio05 {

    public static boolean validarSqlSeguro(String query) {

        return query.startsWith("SELECT")
            && !query.contains("DROP")
            && !query.contains("DELETE")
            && !query.contains("--")
            && query.endsWith(";");
    }

    public static void main(String[] args) {

        // Teste 1 - query valida -> true
        boolean r1 = validarSqlSeguro("SELECT nome FROM usuarios;");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 - sem ponto e virgula no fim -> false
        boolean r2 = validarSqlSeguro("SELECT nome FROM usuarios");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 - contem DELETE -> false
        boolean r3 = validarSqlSeguro("DELETE FROM usuarios WHERE id = 1;");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");

        // Teste 4 - contem "--" (injecao SQL) -> false
        boolean r4 = validarSqlSeguro("SELECT nome FROM usuarios -- comentario;");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 - contem DROP -> false
        boolean r5 = validarSqlSeguro("SELECT nome FROM usuarios; DROP TABLE usuarios;");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5 ? "PASSOU" : "FALHOU");
    }
}
