package exercicios.isempty_isblank;

/**
 * Exercicio 04 — isEmpty() e isBlank()
 *
 * Enunciado:
 * Implemente `primeiroCampoPreenchido` que recebe um array de Strings e
 * retorna a primeira string que não seja nula, vazia ou só espaços.
 * Se não encontrar nenhuma, retorne null.
 */
public class Exercicio04 {

    public static String primeiroCampoPreenchido(String[] campos) {

        for (String campo : campos) {

            if (campo != null && !campo.isBlank()) return campo;
        }

        return null;
    }

    public static void main(String[] args) {

        String r1 = primeiroCampoPreenchido(new String[]{null, "", "  ", "Rafael", "Java"});
        String r2 = primeiroCampoPreenchido(new String[]{"", "   ", null});
        String r3 = primeiroCampoPreenchido(new String[]{"Java", "Python"});
        String r4 = primeiroCampoPreenchido(new String[]{});
        String r5 = primeiroCampoPreenchido(new String[]{null, "  ", "ok"});

        // Teste 1 — três inválidos antes → retorna "Rafael"
        System.out.printf("Teste 1 | Esperado: %-8s | Obtido: %-8s | %s%n", "Rafael", r1, "Rafael".equals(r1) ? "PASSOU" : "FALHOU");

        // Teste 2 — todos inválidos → null
        System.out.printf("Teste 2 | Esperado: %-8s | Obtido: %-8s | %s%n", "null", r2, r2 == null ? "PASSOU" : "FALHOU");

        // Teste 3 — primeiro já é válido → "Java"
        System.out.printf("Teste 3 | Esperado: %-8s | Obtido: %-8s | %s%n", "Java", r3, "Java".equals(r3) ? "PASSOU" : "FALHOU");

        // Teste 4 — array vazio → null
        System.out.printf("Teste 4 | Esperado: %-8s | Obtido: %-8s | %s%n", "null", r4, r4 == null ? "PASSOU" : "FALHOU");

        // Teste 5 — null e branco antes → retorna "ok"
        System.out.printf("Teste 5 | Esperado: %-8s | Obtido: %-8s | %s%n", "ok", r5, "ok".equals(r5) ? "PASSOU" : "FALHOU");
    }
}
