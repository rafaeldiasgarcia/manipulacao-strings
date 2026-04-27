package exercicios.inspecao_validacao.length;

/**
 * Exercicio 03 - length()
 *
 * Enunciado:
 * Implemente `maisLonga` que recebe duas Strings e retorna a que
 * tiver mais caracteres. Se tiverem o mesmo tamanho, retorne a primeira.
 *
 * Restricao: use apenas length(). Sem loops.
 */
public class Exercicio03 {

    public static String maisLonga(String a, String b) {

        return a.length() >= b.length() ? a : b;
    }

    public static void main(String[] args) {

        // Teste 1 - "Python"(6) > "Java"(4) -> segunda e maior
        String r1 = maisLonga("Java", "Python");
        System.out.printf("Teste 1 | Esperado: %-12s | Obtido: %-12s | %s%n", "Python",     r1, "Python".equals(r1)     ? "PASSOU" : "FALHOU");

        // Teste 2 - "JavaScript"(10) > "Go"(2) -> primeira e maior
        String r2 = maisLonga("JavaScript", "Go");
        System.out.printf("Teste 2 | Esperado: %-12s | Obtido: %-12s | %s%n", "JavaScript", r2, "JavaScript".equals(r2) ? "PASSOU" : "FALHOU");

        // Teste 3 - "Java"(4) == "Rust"(4) -> mesmo tamanho, retorna primeira
        String r3 = maisLonga("Java", "Rust");
        System.out.printf("Teste 3 | Esperado: %-12s | Obtido: %-12s | %s%n", "Java",       r3, "Java".equals(r3)       ? "PASSOU" : "FALHOU");

        // Teste 4 - ""(0) < "Kotlin"(6) -> segunda e maior
        String r4 = maisLonga("", "Kotlin");
        System.out.printf("Teste 4 | Esperado: %-12s | Obtido: %-12s | %s%n", "Kotlin",     r4, "Kotlin".equals(r4)     ? "PASSOU" : "FALHOU");

        // Teste 5 - ""(0) == ""(0) -> mesmo tamanho, retorna primeira
        String r5 = maisLonga("", "");
        System.out.printf("Teste 5 | Esperado: %-12s | Obtido: %-12s | %s%n", "(vazia)",    r5, "".equals(r5)           ? "PASSOU" : "FALHOU");
    }
}
