package exercicios.inspecao_validacao.isempty_isblank;

/**
 * Exercicio 03 - isEmpty() e isBlank()
 *
 * Enunciado:
 * Implemente `contarCamposVazios` que recebe um array de Strings e retorna
 * quantos elementos sao nulos, vazios ou contem apenas espacos em branco.
 */
public class Exercicio03 {

    public static int contarCamposVazios(String[] campos) {

        int contador = 0;
        for (String campo : campos) {

            if (campo == null || campo.isBlank()) contador++;
        }

        return contador;
    }

    public static void main(String[] args) {

        // Teste 1 - mix: "", "   " e null sao vazios -> 3
        int r1 = contarCamposVazios(new String[]{"Rafael", "", "   ", null, "Java"});
        System.out.printf("Teste 1 | Esperado: %-2d | Obtido: %-2d | %s%n", 3, r1, r1 == 3 ? "PASSOU" : "FALHOU");

        // Teste 2 - todas vazias -> 3
        int r2 = contarCamposVazios(new String[]{"", "", ""});
        System.out.printf("Teste 2 | Esperado: %-2d | Obtido: %-2d | %s%n", 3, r2, r2 == 3 ? "PASSOU" : "FALHOU");

        // Teste 3 - nenhuma vazia -> 0
        int r3 = contarCamposVazios(new String[]{"Java", "Python", "Go"});
        System.out.printf("Teste 3 | Esperado: %-2d | Obtido: %-2d | %s%n", 0, r3, r3 == 0 ? "PASSOU" : "FALHOU");

        // Teste 4 - dois nulls e um branco -> 3
        int r4 = contarCamposVazios(new String[]{null, null, "ok", "  "});
        System.out.printf("Teste 4 | Esperado: %-2d | Obtido: %-2d | %s%n", 3, r4, r4 == 3 ? "PASSOU" : "FALHOU");

        // Teste 5 - array vazio -> 0
        int r5 = contarCamposVazios(new String[]{});
        System.out.printf("Teste 5 | Esperado: %-2d | Obtido: %-2d | %s%n", 0, r5, r5 == 0 ? "PASSOU" : "FALHOU");
    }
}
