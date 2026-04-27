package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 04 - Contar ocorrências de um caractere
 *
 * Implemente `contarOcorrencias` que recebe uma String e um char,
 * e retorna quantas vezes aquele caractere aparece na String.
 *
 * Ex: contarOcorrencias("banana", 'a') → 3
 *
 * Se a String for nula, retorne 0.
 *
 * Restrição: use indexOf(char, fromIndex) num loop — sem split(), sem toCharArray().
 */
public class Exercicio04a {

    public static int contarOcorrencias(String texto, char caractere) {

        int contador = 0;

        if (texto != null) {

            int posicao = 0;
            while ((posicao = texto.indexOf(caractere, posicao)) != -1) {

                contador++;
                posicao++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 04: contarOcorrencias ---");

        // Teste 1 - 'a' aparece em banana 3x → 3
        int r1 = contarOcorrencias("banana", 'a');
        System.out.printf("Teste 1 | Esperado: %-3d | Obtido: %-3d | %s%n", 3, r1, r1 == 3 ? "PASSOU" : "FALHOU");

        // Teste 2 - 'l' aparece em "hello world" 3x (ll + l) → 3
        int r2 = contarOcorrencias("hello world", 'l');
        System.out.printf("Teste 2 | Esperado: %-3d | Obtido: %-3d | %s%n", 3, r2, r2 == 3 ? "PASSOU" : "FALHOU");

        // Teste 3 - 'z' não existe → 0
        int r3 = contarOcorrencias("java", 'z');
        System.out.printf("Teste 3 | Esperado: %-3d | Obtido: %-3d | %s%n", 0, r3, r3 == 0 ? "PASSOU" : "FALHOU");

        // Teste 4 - nulo → 0
        int r4 = contarOcorrencias(null, 'a');
        System.out.printf("Teste 4 | Esperado: %-3d | Obtido: %-3d | %s%n", 0, r4, r4 == 0 ? "PASSOU" : "FALHOU");

        // Teste 5 - todos os chars iguais → 3
        int r5 = contarOcorrencias("aaa", 'a');
        System.out.printf("Teste 5 | Esperado: %-3d | Obtido: %-3d | %s%n", 3, r5, r5 == 3 ? "PASSOU" : "FALHOU");
    }
}
