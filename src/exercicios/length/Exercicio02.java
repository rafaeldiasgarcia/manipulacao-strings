package exercicios.length;

/**
 * Exercicio 02 — length()
 *
 * Enunciado:
 * Implemente `senhaValida` que recebe uma String senha e retorna
 * true se ela tiver pelo menos 8 caracteres, false caso contrário.
 *
 * Restrição: use apenas length(). Sem loops.
 */
public class Exercicio02 {

    public static boolean senhaValida(String senha) {

        return senha.length() >= 8;
    }

    public static void main(String[] args) {
        // Teste 1 — exatamente 8 caracteres (limite mínimo, deve passar)
        boolean r1 = senhaValida("12345678");
        System.out.println("Teste 1 | Esperado: true  | Obtido: " + r1 + " | " + (r1 == true  ? "PASSOU" : "FALHOU"));

        // Teste 2 — 7 caracteres (abaixo do mínimo)
        boolean r2 = senhaValida("1234567");
        System.out.println("Teste 2 | Esperado: false | Obtido: " + r2 + " | " + (r2 == false ? "PASSOU" : "FALHOU"));

        // Teste 3 — senha longa (bem acima do mínimo)
        boolean r3 = senhaValida("minhaSenhaForte2024");
        System.out.println("Teste 3 | Esperado: true  | Obtido: " + r3 + " | " + (r3 == true  ? "PASSOU" : "FALHOU"));

        // Teste 4 — string vazia
        boolean r4 = senhaValida("");
        System.out.println("Teste 4 | Esperado: false | Obtido: " + r4 + " | " + (r4 == false ? "PASSOU" : "FALHOU"));

        // Teste 5 — exatamente 1 caractere
        boolean r5 = senhaValida("x");
        System.out.println("Teste 5 | Esperado: false | Obtido: " + r5 + " | " + (r5 == false ? "PASSOU" : "FALHOU"));
    }
}
