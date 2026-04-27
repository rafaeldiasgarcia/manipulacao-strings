package exercicios.fatiamento_busca.charat;

/**
 * Exercicio 01 - charAt()
 *
 * Enunciado:
 * Você precisa criar um sistema que identifique o gênero de uma pessoa com base no
 * primeiro caractere do código digitado no sistema.
 * 
 * Implemente a função `obterGenero` que recebe uma String (ex: "Masculino", "Feminino", "Outro")
 * e retorna apenas a PRIMEIRA letra (o caractere) dessa String.
 * 
 * Restricao: A String PODE ser nula ou vazia. Se isso acontecer, retorne um espaço em branco (' '). Trate para evitar erros!
 */
public class Exercicio01 {

    public static char obterGenero(String palavra) {

        return palavra != null && !palavra.isBlank() ? palavra.charAt(0) : ' ';
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 01: charAt ---");

        // Teste 1
        char r1 = obterGenero("Masculino");
        System.out.printf("Teste 1 | Esperado: %-5c | Obtido: %-5c | %s%n", 'M', r1, r1 == 'M' ? "PASSOU" : "FALHOU");

        // Teste 2
        char r2 = obterGenero("Feminino");
        System.out.printf("Teste 2 | Esperado: %-5c | Obtido: %-5c | %s%n", 'F', r2, r2 == 'F' ? "PASSOU" : "FALHOU");

        // Teste 3
        char r3 = obterGenero("Outro");
        System.out.printf("Teste 3 | Esperado: %-5c | Obtido: %-5c | %s%n", 'O', r3, r3 == 'O' ? "PASSOU" : "FALHOU");

        // Teste 4 - Nulo
        char r4 = obterGenero(null);
        System.out.printf("Teste 4 | Esperado: %-5c | Obtido: %-5c | %s%n", ' ', r4, r4 == ' ' ? "PASSOU" : "FALHOU");

        // Teste 5 - Vazio
        char r5 = obterGenero("");
        System.out.printf("Teste 5 | Esperado: %-5c | Obtido: %-5c | %s%n", ' ', r5, r5 == ' ' ? "PASSOU" : "FALHOU");
    }
}
