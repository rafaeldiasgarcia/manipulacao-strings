package exercicios.isempty_isblank;

/**
 * Exercicio 02 — isEmpty() vs isBlank()
 * <p>
 * Enunciado:
 * Implemente `classificar` que recebe uma String e retorna:
 * "NULO"       → se for null
 * "VAZIO"      → se for "" (length zero)
 * "BRANCO"     → se tiver apenas espacos ou tabs
 * "PREENCHIDO" → caso contrário
 * <p>
 * Dica: a ordem dos ifs importa.
 */
public class Exercicio02 {

    public static String classificar(String valor) {

        if (valor == null) return "NULO";
        if (valor.isEmpty()) return "VAZIO";
        if (valor.isBlank()) return "BRANCO";

        return "PREENCHIDO";
    }

    public static void main(String[] args) {

        String r1 = classificar(null);
        String r2 = classificar("");
        String r3 = classificar("   ");
        String r4 = classificar("Java");
        String r5 = classificar("\t");

        // Teste 1 — null → NULO
        System.out.printf("Teste 1 | Esperado: %-12s | Obtido: %-12s | %s%n", "NULO",       r1, "NULO".equals(r1)       ? "PASSOU" : "FALHOU");

        // Teste 2 — "" → VAZIO (isEmpty = true)
        System.out.printf("Teste 2 | Esperado: %-12s | Obtido: %-12s | %s%n", "VAZIO",      r2, "VAZIO".equals(r2)      ? "PASSOU" : "FALHOU");

        // Teste 3 — só espaços → BRANCO (isBlank = true, isEmpty = false)
        System.out.printf("Teste 3 | Esperado: %-12s | Obtido: %-12s | %s%n", "BRANCO",     r3, "BRANCO".equals(r3)     ? "PASSOU" : "FALHOU");

        // Teste 4 — texto real → PREENCHIDO
        System.out.printf("Teste 4 | Esperado: %-12s | Obtido: %-12s | %s%n", "PREENCHIDO", r4, "PREENCHIDO".equals(r4) ? "PASSOU" : "FALHOU");

        // Teste 5 — tab é whitespace → BRANCO
        System.out.printf("Teste 5 | Esperado: %-12s | Obtido: %-12s | %s%n", "BRANCO",     r5, "BRANCO".equals(r5)     ? "PASSOU" : "FALHOU");
    }
}
