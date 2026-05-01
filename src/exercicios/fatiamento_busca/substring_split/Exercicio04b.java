package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 04b - split() com Regex (Separadores irregulares)
 *
 * Enunciado:
 * Às vezes você recebe dados do usuário onde os espaços estão bagunçados:
 * ex: "Joao   da     Silva".
 * Se você usar `split(" ")` (um único espaço), o array ficará cheio de strings
 * vazias porque há múltiplos espaços seguidos.
 *
 * O `split` recebe internamente uma Expressão Regular (Regex). Você pode
 * dizer para ele "cortar onde houver UM OU MAIS espaços" passando "\\s+".
 *
 * Implemente `extrairPalavras` que ignora a bagunça dos espaços repetidos
 * e devolve apenas as palavras corretas em um array.
 *
 * Restrições:
 * - Se nulo, retorne um array vazio.
 * - Dica de ouro: Se a string apenas tiver espaços ("   ") ou for vazia, o regex "\\s+"
 *   retorna array de 0 na nova JVM ou posições bizarras em JVMs velhas. Proteja usando `isBlank()`!
 */
public class Exercicio04b {

    public static String[] extrairPalavras(String frase) {

        if (frase == null) return new String[0];
        if (frase.isBlank()) return new String[0];

        return frase.trim().split("\\s+");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04b: extrairPalavras ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        String[] r1 = extrairPalavras("Joao   da     Silva");
        boolean t1 = r1 != null && r1.length == 3 && "Silva".equals(r1[2]);
        System.out.printf("Teste 1 | Esperado %d | Obtido: %d | %s%n", 3, r1 != null ? r1.length : -1, t1 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String[] r2 = extrairPalavras("   espacos   nas   pontas   ");
        // O Java com regex no split tende a criar um elemento vazio na posição 0 se
        // a string COMEÇAR pelo delimitador. O ideal no mundo real é sempre aplicar um trim() ANTES do split.
        // Esse teste valida se você pensou no trim()!
        boolean t2 = r2 != null && r2.length == 3 && "pontas".equals(r2[2]);
        System.out.printf("Teste 2 | Esperado %d | Obtido: %d | %s%n", 3, r2 != null ? r2.length : -1, t2 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String[] r3 = extrairPalavras("backend");
        boolean t3 = r3 != null && r3.length == 1 && "backend".equals(r3[0]);
        System.out.printf("Teste 3 | Esperado %d | Obtido: %d | %s%n", 1, r3 != null ? r3.length : -1, t3 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String[] r4 = extrairPalavras("");
        boolean t4 = r4 != null && r4.length == 0;
        System.out.printf("Teste 4 | Esperado %d | Obtido: %d | %s%n", 0, r4 != null ? r4.length : -1, t4 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String[] r5 = extrairPalavras("       ");
        boolean t5 = r5 != null && r5.length == 0;
        System.out.printf("Teste 5 | Esperado %d | Obtido: %d | %s%n", 0, r5 != null ? r5.length : -1, t5 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String[] r6 = extrairPalavras(null);
        boolean t6 = r6 != null && r6.length == 0;
        System.out.printf("Teste 6 | Esperado %d | Obtido: %d | %s%n", 0, r6 != null ? r6.length : -1, t6 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
