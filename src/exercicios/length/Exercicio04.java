package exercicios.length;

/**
 * Exercicio 04 — length()
 *
 * Enunciado:
 * Implemente `contarPalavrasCurtas` que recebe um array de Strings e um
 * limite inteiro, e retorna quantas palavras têm length <= limite.
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
        // Teste 1 — limite 3: "Go"(2) e "C"(1) passam
        int r1 = contarPalavrasCurtas(new String[]{"Java", "Go", "Python", "C"}, 3);
        System.out.println("Teste 1 | Esperado: 2 | Obtido: " + r1 + " | " + (r1 == 2 ? "PASSOU" : "FALHOU"));

        // Teste 2 — limite 4: todas com até 4 chars
        int r2 = contarPalavrasCurtas(new String[]{"Java", "Go", "C", "Rust"}, 4);
        System.out.println("Teste 2 | Esperado: 4 | Obtido: " + r2 + " | " + (r2 == 4 ? "PASSOU" : "FALHOU"));

        // Teste 3 — limite 0: nenhuma passa (strings não vazias)
        int r3 = contarPalavrasCurtas(new String[]{"Java", "Go"}, 0);
        System.out.println("Teste 3 | Esperado: 0 | Obtido: " + r3 + " | " + (r3 == 0 ? "PASSOU" : "FALHOU"));

        // Teste 4 — array vazio
        int r4 = contarPalavrasCurtas(new String[]{}, 5);
        System.out.println("Teste 4 | Esperado: 0 | Obtido: " + r4 + " | " + (r4 == 0 ? "PASSOU" : "FALHOU"));

        // Teste 5 — limite exato no tamanho de uma palavra (Kotlin=6 também entra)
        int r5 = contarPalavrasCurtas(new String[]{"Kotlin", "Go", "Swift", "C"}, 6);
        System.out.println("Teste 5 | Esperado: 4 | Obtido: " + r5 + " | " + (r5 == 4 ? "PASSOU" : "FALHOU"));
    }
}
