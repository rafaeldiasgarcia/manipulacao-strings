package exercicios.fatiamento_busca.charat;

/**
 * Exercicio 04 - Contando Vogais (O clássico!)
 *
 * Enunciado:
 * A verdadeira força do `charAt` aparece quando percorremos a String em um laço de repetição.
 * 
 * Implemente a função `contarVogais` que recebe um texto e retorna a quantidade (int) de 
 * vogais existentes nele ('A', 'E', 'I', 'O', 'U', minúsculas ou maiúsculas).
 * 
 * Dica: Você precisará de um `for` (de 0 até length() - 1) e chamar o `charAt(i)`.
 * Não se preocupe com acentuação neste exercício (considere apenas "aeiou").
 * 
 * Restricao: Se a String for nula, o retorno deve ser 0 (zero).
 */
public class Exercicio04 {

    public static int contarVogais(String texto) {

        if (texto == null) {
            return 0;
        }

        int contadorVogais = 0;
        for (int i = 0; i < texto.length(); i++) {

            char c = Character.toLowerCase(texto.charAt(i));

            switch (c) {
                case 'a', 'e', 'i', 'o', 'u' -> contadorVogais++;
            }
        }

        return contadorVogais;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 04: contarVogais ---");

        // Teste 1 - Apenas minusculas
        int r1 = contarVogais("java");
        System.out.printf("Teste 1 | Esperado: %-5d | Obtido: %-5d | %s%n", 2, r1, r1 == 2 ? "PASSOU" : "FALHOU");

        // Teste 2 - Misturado maiusculo e minusculo
        int r2 = contarVogais("Antigravity");
        System.out.printf("Teste 2 | Esperado: %-5d | Obtido: %-5d | %s%n", 4, r2, r2 == 4 ? "PASSOU" : "FALHOU");

        // Teste 3 - Sem vogais
        int r3 = contarVogais("xyz");
        System.out.printf("Teste 3 | Esperado: %-5d | Obtido: %-5d | %s%n", 0, r3, r3 == 0 ? "PASSOU" : "FALHOU");

        // Teste 4 - Apenas espacos e numeros
        int r4 = contarVogais("123 456");
        System.out.printf("Teste 4 | Esperado: %-5d | Obtido: %-5d | %s%n", 0, r4, r4 == 0 ? "PASSOU" : "FALHOU");

        // Teste 5 - Nulo
        int r5 = contarVogais(null);
        System.out.printf("Teste 5 | Esperado: %-5d | Obtido: %-5d | %s%n", 0, r5, r5 == 0 ? "PASSOU" : "FALHOU");
    }
}
