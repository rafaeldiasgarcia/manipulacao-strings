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

        if (nome.length() < 3  || nome.length() > 50)  return false;
        if (email.length() < 5 || email.length() > 100) return false;
        if (senha.length() < 8 || senha.length() > 20)  return false;

        return true;
    }

    public static void main(String[] args) {

        boolean r1 = validarCadastro("Rafael", "rafael@email.com", "senha123");
        boolean r2 = validarCadastro("Jo", "jo@email.com", "senha123");
        boolean r3 = validarCadastro("Rafael", "rafael@email.com", "senhaMuitoLongaDemais");
        boolean r4 = validarCadastro("Rafael", "r@io", "senha123");
        boolean r5 = validarCadastro("Ana", "a@b.c", "12345678");

        // Teste 1 — todos os campos válidos → true
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 — nome "Jo" tem 2 chars, mínimo é 3 → false
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 — senha tem 21 chars, máximo é 20 → false
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");

        // Teste 4 — email "r@io" tem 4 chars, mínimo é 5 → false
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 — todos nos limites mínimos exatos → true
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r5,  r5 ? "PASSOU" : "FALHOU");
    }
}
