package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 04d - Verificar se uma substring se repete
 *
 * Implemente `apareceMultiplasVezes` que recebe uma String e uma substring,
 * e retorna true se a substring aparecer MAIS DE UMA VEZ no texto.
 *
 * Ex: apareceMultiplasVezes("abcabc", "abc") → true
 *     apareceMultiplasVezes("abcdef", "abc") → false
 *
 * Se qualquer argumento for nulo ou a substring for vazia, retorne false.
 *
 * Restrição: use indexOf(String, fromIndex) — sem split(), sem contains() em loop.
 */
public class Exercicio04d {

    public static boolean apareceMultiplasVezes(String texto, String substring) {

        if (texto == null || substring == null || substring.isEmpty()) return false;

        int pos = texto.indexOf(substring);
        if (pos == -1) return false;

        return texto.indexOf(substring, pos + substring.length()) != -1;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 04d: apareceMultiplasVezes ---");

        // Teste 1 - "abc" aparece 2x → true
        boolean r1 = apareceMultiplasVezes("abcabc", "abc");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - "um" aparece 3x → true
        boolean r2 = apareceMultiplasVezes("um dois um tres um", "um");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r2, r2 == true ? "PASSOU" : "FALHOU");

        // Teste 3 - "abc" aparece só 1x → false
        boolean r3 = apareceMultiplasVezes("abcdef", "abc");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r3, r3 == false ? "PASSOU" : "FALHOU");

        // Teste 4 - texto nulo → false
        boolean r4 = apareceMultiplasVezes(null, "abc");
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r4, r4 == false ? "PASSOU" : "FALHOU");

        // Teste 5 - substring vazia → false
        boolean r5 = apareceMultiplasVezes("abcabc", "");
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r5, r5 == false ? "PASSOU" : "FALHOU");
    }
}
