package exercicios.length;

/**
 * Exercicio 03 — length()
 *
 * Enunciado:
 * Implemente `maisLonga` que recebe duas Strings e retorna a que
 * tiver mais caracteres. Se tiverem o mesmo tamanho, retorne a primeira.
 *
 * Restrição: use apenas length(). Sem loops.
 */
public class Exercicio03 {

    public static String maisLonga(String a, String b) {

        return a.length() >= b.length() ? a : b;
    }

    public static void main(String[] args) {
        // Teste 1 — segunda é maior
        String r1 = maisLonga("Java", "Python");
        System.out.println("Teste 1 | Esperado: Python    | Obtido: " + r1 + " | " + ("Python".equals(r1) ? "PASSOU" : "FALHOU"));

        // Teste 2 — primeira é maior
        String r2 = maisLonga("JavaScript", "Go");
        System.out.println("Teste 2 | Esperado: JavaScript | Obtido: " + r2 + " | " + ("JavaScript".equals(r2) ? "PASSOU" : "FALHOU"));

        // Teste 3 — mesmo tamanho, retorna a primeira
        String r3 = maisLonga("Java", "Rust");
        System.out.println("Teste 3 | Esperado: Java       | Obtido: " + r3 + " | " + ("Java".equals(r3) ? "PASSOU" : "FALHOU"));

        // Teste 4 — primeira é vazia
        String r4 = maisLonga("", "Kotlin");
        System.out.println("Teste 4 | Esperado: Kotlin     | Obtido: " + r4 + " | " + ("Kotlin".equals(r4) ? "PASSOU" : "FALHOU"));

        // Teste 5 — ambas vazias, retorna a primeira
        String r5 = maisLonga("", "");
        System.out.println("Teste 5 | Esperado: (vazia)    | Obtido: '" + r5 + "' | " + ("".equals(r5) ? "PASSOU" : "FALHOU"));
    }
}
