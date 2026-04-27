package exercicios.fatiamento_busca.charat;

/**
 * Exercicio 03 - O caractere do meio
 *
 * Enunciado:
 * Vamos treinar um pouco de lógica matemática com índices!
 * Implemente a função `obterCaractereDoMeio` que retorna a letra que está exatamente
 * no centro da palavra.
 * 
 * Regras:
 * 1. Se a palavra tem um número ímpar de letras, retorne a do meio (Ex: "ABC" -> 'B').
 * 2. Se a palavra tem um número par de letras, retorne a primeira letra da segunda metade
 *    (Ex: "Java" tem 4 letras. Metade é 2. charAt(2) é 'v'. Então "Java" -> 'v').
 * 
 * Dica: O Java faz divisão inteira nativamente quando você divide dois `int`.
 * 
 * Restricao: Se a String for nula ou vazia, retorne o caractere espaço (' ').
 */
public class Exercicio03 {

    public static char obterCaractereDoMeio(String palavra) {

        return palavra != null && !palavra.isEmpty() ? palavra.charAt(palavra.length() / 2) : ' ';
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 03: obterCaractereDoMeio ---");

        // Teste 1 - Impar
        char r1 = obterCaractereDoMeio("ABC");
        System.out.printf("Teste 1 | Esperado: %-5c | Obtido: %-5c | %s%n", 'B', r1, r1 == 'B' ? "PASSOU" : "FALHOU");

        // Teste 2 - Par
        char r2 = obterCaractereDoMeio("Java");
        System.out.printf("Teste 2 | Esperado: %-5c | Obtido: %-5c | %s%n", 'v', r2, r2 == 'v' ? "PASSOU" : "FALHOU");

        // Teste 3 - Palavra longa impar
        char r3 = obterCaractereDoMeio("Programador");
        System.out.printf("Teste 3 | Esperado: %-5c | Obtido: %-5c | %s%n", 'a', r3, r3 == 'a' ? "PASSOU" : "FALHOU");

        // Teste 4 - Nulo
        char r4 = obterCaractereDoMeio(null);
        System.out.printf("Teste 4 | Esperado: %-5c | Obtido: %-5c | %s%n", ' ', r4, r4 == ' ' ? "PASSOU" : "FALHOU");

        // Teste 5 - Vazio
        char r5 = obterCaractereDoMeio("");
        System.out.printf("Teste 5 | Esperado: %-5c | Obtido: %-5c | %s%n", ' ', r5, r5 == ' ' ? "PASSOU" : "FALHOU");
    }
}
