package exercicios.length;

/**
 * Exercicio 01 — length()
 *
 * Enunciado:
 * Implemente o método `contarCaracteres` que recebe uma String
 * e retorna a quantidade de caracteres que ela possui.
 *
 * Restrição: use apenas length(). Nada de loops.
 */
public class Exercicio01 {

    public static int contarCaracteres(String texto) {

       return texto.length();
    }

    public static void main(String[] args) {
        // Teste 1 — palavra simples
        int r1 = contarCaracteres("Java");
        System.out.println("Teste 1 | Esperado: 4  | Obtido: " + r1 + " | " + (r1 == 4 ? "PASSOU" : "FALHOU"));

        // Teste 2 — string vazia
        int r2 = contarCaracteres("");
        System.out.println("Teste 2 | Esperado: 0  | Obtido: " + r2 + " | " + (r2 == 0 ? "PASSOU" : "FALHOU"));

        // Teste 3 — frase com espaço
        int r3 = contarCaracteres("Ola Mundo");
        System.out.println("Teste 3 | Esperado: 9  | Obtido: " + r3 + " | " + (r3 == 9 ? "PASSOU" : "FALHOU"));

        // Teste 4 — apenas um espaço (espaço conta como caractere)
        int r4 = contarCaracteres(" ");
        System.out.println("Teste 4 | Esperado: 1  | Obtido: " + r4 + " | " + (r4 == 1 ? "PASSOU" : "FALHOU"));

        // Teste 5 — número como string
        int r5 = contarCaracteres("12345");
        System.out.println("Teste 5 | Esperado: 5  | Obtido: " + r5 + " | " + (r5 == 5 ? "PASSOU" : "FALHOU"));
    }
}
