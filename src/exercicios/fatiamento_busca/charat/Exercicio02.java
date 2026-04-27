package exercicios.fatiamento_busca.charat;

/**
 * Exercicio 02 - O ultimo caractere
 *
 * Enunciado:
 * Frequentemente precisamos verificar como um texto termina (ex: pontuação).
 * 
 * Implemente a função `obterUltimaLetra` que recebe uma String e retorna a sua ÚLTIMA letra.
 * Dica: Como você sabe qual é o índice do último caractere de forma dinâmica? 
 * Lembre-se que o índice começa no zero!
 * 
 * Restricao: Se a String for nula ou vazia, retorne o caractere espaço (' ').
 */
public class Exercicio02 {

    public static char obterUltimaLetra(String texto) {

        return texto != null && !texto.isEmpty() ? texto.charAt(texto.length() - 1) : ' ';
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 02: obterUltimaLetra ---");

        // Teste 1 - Palavra normal
        char r1 = obterUltimaLetra("Java");
        System.out.printf("Teste 1 | Esperado: %-5c | Obtido: %-5c | %s%n", 'a', r1, r1 == 'a' ? "PASSOU" : "FALHOU");

        // Teste 2 - Frase terminando com pontuacao
        char r2 = obterUltimaLetra("E ai, beleza?");
        System.out.printf("Teste 2 | Esperado: %-5c | Obtido: %-5c | %s%n", '?', r2, r2 == '?' ? "PASSOU" : "FALHOU");

        // Teste 3 - Uma unica letra (primeira e ultima ao mesmo tempo)
        char r3 = obterUltimaLetra("A");
        System.out.printf("Teste 3 | Esperado: %-5c | Obtido: %-5c | %s%n", 'A', r3, r3 == 'A' ? "PASSOU" : "FALHOU");

        // Teste 4 - Nulo
        char r4 = obterUltimaLetra(null);
        System.out.printf("Teste 4 | Esperado: %-5c | Obtido: %-5c | %s%n", ' ', r4, r4 == ' ' ? "PASSOU" : "FALHOU");

        // Teste 5 - Vazio
        char r5 = obterUltimaLetra("");
        System.out.printf("Teste 5 | Esperado: %-5c | Obtido: %-5c | %s%n", ' ', r5, r5 == ' ' ? "PASSOU" : "FALHOU");
    }
}
