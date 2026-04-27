package exercicios.inspecao_validacao.length;

import util.Cronometro;

/**
 * Exercicio 01 - length()
 *
 * Enunciado:
 * Implemente o método `contarCaracteres` que recebe uma String
 * e retorna a quantidade de caracteres que ela possui.
 *
 * Restricao: use apenas length(). Nada de loops.
 */
public class Exercicio01 {

    public static int contarCaracteres(String texto) {

        return texto.length();
    }

    public static void main(String[] args) {

        // Teste 1 - palavra simples -> "Java" tem 4 chars
        Cronometro.iniciar();
        int r1 = contarCaracteres("Java");
        System.out.printf("Teste 1 | Esperado: %-4d | Obtido: %-4d | %s%n", 4, r1, r1 == 4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - string vazia -> 0
        Cronometro.iniciar();
        int r2 = contarCaracteres("");
        System.out.printf("Teste 2 | Esperado: %-4d | Obtido: %-4d | %s%n", 0, r2, r2 == 0 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - frase com espaco -> espaco conta como caractere
        Cronometro.iniciar();
        int r3 = contarCaracteres("Ola Mundo");
        System.out.printf("Teste 3 | Esperado: %-4d | Obtido: %-4d | %s%n", 9, r3, r3 == 9 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - so espaco -> 1
        Cronometro.iniciar();
        int r4 = contarCaracteres(" ");
        System.out.printf("Teste 4 | Esperado: %-4d | Obtido: %-4d | %s%n", 1, r4, r4 == 1 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - numero como string -> 5
        Cronometro.iniciar();
        int r5 = contarCaracteres("12345");
        System.out.printf("Teste 5 | Esperado: %-4d | Obtido: %-4d | %s%n", 5, r5, r5 == 5 ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
