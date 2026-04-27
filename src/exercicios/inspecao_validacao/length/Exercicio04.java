package exercicios.inspecao_validacao.length;

import util.Cronometro;

/**
 * Exercicio 04 - length()
 *
 * Enunciado:
 * Implemente `contarPalavrasCurtas` que recebe um array de Strings e um
 * limite inteiro, e retorna quantas palavras tem length <= limite.
 */
public class Exercicio04 {

    public static int contarPalavrasCurtas(String[] palavras, int limite) {

        int contador = 0;
        for (String palavra : palavras) {

            if (palavra.length() <= limite) contador++;
        }

        return contador;
    }

    public static void main(String[] args) {

        // Teste 1 - limite 3: "Go"(2) e "C"(1) passam -> 2
        Cronometro.iniciar();
        int r1 = contarPalavrasCurtas(new String[]{"Java", "Go", "Python", "C"}, 3);
        System.out.printf("Teste 1 | Esperado: %-2d | Obtido: %-2d | %s%n", 2, r1, r1 == 2 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - limite 4: todas com ate 4 chars -> 4
        Cronometro.iniciar();
        int r2 = contarPalavrasCurtas(new String[]{"Java", "Go", "C", "Rust"}, 4);
        System.out.printf("Teste 2 | Esperado: %-2d | Obtido: %-2d | %s%n", 4, r2, r2 == 4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - limite 0: nenhuma passa -> 0
        Cronometro.iniciar();
        int r3 = contarPalavrasCurtas(new String[]{"Java", "Go"}, 0);
        System.out.printf("Teste 3 | Esperado: %-2d | Obtido: %-2d | %s%n", 0, r3, r3 == 0 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - array vazio -> 0
        Cronometro.iniciar();
        int r4 = contarPalavrasCurtas(new String[]{}, 5);
        System.out.printf("Teste 4 | Esperado: %-2d | Obtido: %-2d | %s%n", 0, r4, r4 == 0 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - limite 6: "Kotlin"(6) tambem entra -> 4
        Cronometro.iniciar();
        int r5 = contarPalavrasCurtas(new String[]{"Kotlin", "Go", "Swift", "C"}, 6);
        System.out.printf("Teste 5 | Esperado: %-2d | Obtido: %-2d | %s%n", 4, r5, r5 == 4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
