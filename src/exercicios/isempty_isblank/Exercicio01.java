package exercicios.isempty_isblank;

/**
 * Exercicio 01 — isEmpty() e isBlank()
 *
 * Enunciado:
 * Implemente `campoPreenchido` que recebe uma String e retorna true
 * se o campo tiver conteúdo real (não nulo, não vazio, não só espaços).
 *
 * Trate o caso null antes de chamar qualquer método.
 */
public class Exercicio01 {

    public static boolean campoPreenchido(String valor) {

        if (valor == null) return false;

        return !valor.isBlank();
    }

    public static void main(String[] args) {

        boolean r1 = campoPreenchido("Rafael");
        boolean r2 = campoPreenchido("");
        boolean r3 = campoPreenchido("   ");
        boolean r4 = campoPreenchido(null);
        boolean r5 = campoPreenchido("  Java  ");

        // Teste 1 — texto normal → preenchido
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 — string vazia → não preenchido
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 — só espaços → não preenchido
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");

        // Teste 4 — null → não preenchido
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 — espaços nas bordas mas tem conteúdo → preenchido
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r5,  r5 ? "PASSOU" : "FALHOU");
    }
}
