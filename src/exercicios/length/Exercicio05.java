package exercicios.length;

/**
 * Exercicio 05 — length() [DESAFIO]
 *
 * Enunciado:
 * Implemente `validarCadastro` que recebe nome, email e senha e retorna
 * true somente se TODOS os campos respeitarem as regras abaixo:
 *
 *   nome  → entre 3 e 50 caracteres (inclusive)
 *   email → entre 5 e 100 caracteres (inclusive)
 *   senha → entre 8 e 20 caracteres (inclusive)
 *
 * Se qualquer campo violar sua regra, retorne false.
 * Use apenas length(). Sem loops.
 */
public class Exercicio05 {

    public static boolean validarCadastro(String nome, String email, String senha) {

        if (nome.length() < 3 || nome.length() > 50) return false;
        if (email.length() < 5 || email.length() > 100) return false;
        if (senha.length() < 8 || senha.length() > 20) return false;

        return true;
    }

    public static void main(String[] args) {
        // Teste 1 — todos válidos
        boolean r1 = validarCadastro("Rafael", "rafael@email.com", "senha123");
        System.out.println("Teste 1 | Esperado: true  | Obtido: " + r1 + " | " + (r1 == true  ? "PASSOU" : "FALHOU"));

        // Teste 2 — nome muito curto (2 chars)
        boolean r2 = validarCadastro("Jo", "jo@email.com", "senha123");
        System.out.println("Teste 2 | Esperado: false | Obtido: " + r2 + " | " + (r2 == false ? "PASSOU" : "FALHOU"));

        // Teste 3 — senha muito longa (21 chars)
        boolean r3 = validarCadastro("Rafael", "rafael@email.com", "senhaMuitoLongaDemais");
        System.out.println("Teste 3 | Esperado: false | Obtido: " + r3 + " | " + (r3 == false ? "PASSOU" : "FALHOU"));

        // Teste 4 — email muito curto (4 chars)
        boolean r4 = validarCadastro("Rafael", "r@io", "senha123");
        System.out.println("Teste 4 | Esperado: false | Obtido: " + r4 + " | " + (r4 == false ? "PASSOU" : "FALHOU"));

        // Teste 5 — todos nos limites exatos (mínimos)
        boolean r5 = validarCadastro("Ana", "a@b.c", "12345678");
        System.out.println("Teste 5 | Esperado: true  | Obtido: " + r5 + " | " + (r5 == true  ? "PASSOU" : "FALHOU"));
    }
}
