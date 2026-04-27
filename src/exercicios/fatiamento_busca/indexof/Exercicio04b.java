package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 04b - Encontrar a segunda ocorrência
 *
 * Implemente `segundaOcorrencia` que recebe uma String e um char,
 * e retorna o índice da SEGUNDA ocorrência daquele caractere.
 *
 * Ex: segundaOcorrencia("banana", 'a') → 3
 *
 * Se não houver segunda ocorrência, ou a String for nula, retorne -1.
 *
 * Restrição: use indexOf(char, fromIndex) — sem loop.
 */
public class Exercicio04b {

    public static int segundaOcorrencia(String texto, char caractere) {

        if (texto == null) return -1;

        int posicao = texto.indexOf(caractere);
        if (posicao == -1) return -1;
        
        return texto.indexOf(caractere, posicao + 1);
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 04b: segundaOcorrencia ---");

        // Teste 1 - 'a' aparece em 1, 3, 5 → segunda ocorrência no índice 3
        int r1 = segundaOcorrencia("banana", 'a');
        System.out.printf("Teste 1 | Esperado: %-3d | Obtido: %-3d | %s%n", 3, r1, r1 == 3 ? "PASSOU" : "FALHOU");

        // Teste 2 - 'l' aparece em 2 e 3 → segunda ocorrência no índice 3
        int r2 = segundaOcorrencia("hello", 'l');
        System.out.printf("Teste 2 | Esperado: %-3d | Obtido: %-3d | %s%n", 3, r2, r2 == 3 ? "PASSOU" : "FALHOU");

        // Teste 3 - 'a' aparece só uma vez → -1
        int r3 = segundaOcorrencia("zebra", 'a');
        System.out.printf("Teste 3 | Esperado: %-3d | Obtido: %-3d | %s%n", -1, r3, r3 == -1 ? "PASSOU" : "FALHOU");

        // Teste 4 - 'z' não aparece → -1
        int r4 = segundaOcorrencia("abc", 'z');
        System.out.printf("Teste 4 | Esperado: %-3d | Obtido: %-3d | %s%n", -1, r4, r4 == -1 ? "PASSOU" : "FALHOU");

        // Teste 5 - nulo → -1
        int r5 = segundaOcorrencia(null, 'a');
        System.out.printf("Teste 5 | Esperado: %-3d | Obtido: %-3d | %s%n", -1, r5, r5 == -1 ? "PASSOU" : "FALHOU");
    }
}
