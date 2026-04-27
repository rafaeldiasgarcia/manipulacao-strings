package exercicios.inspecao_validacao.length;

import util.Cronometro;

/**
 * Exercicio 05 - length() [DESAFIO]
 *
 * Enunciado:
 * Implemente `validarCadastro` que recebe nome, email e senha e retorna
 * true somente se TODOS os campos respeitarem as regras abaixo:
 *
 *   nome  -> entre 3 e 50 caracteres (inclusive)
 *   email -> entre 5 e 100 caracteres (inclusive)
 *   senha -> entre 8 e 20 caracteres (inclusive)
 */
public class Exercicio05 {

    public static boolean validarCadastro(String nome, String email, String senha) {

        if (nome.length() < 3  || nome.length() > 50)  return false;
        if (email.length() < 5 || email.length() > 100) return false;
        if (senha.length() < 8 || senha.length() > 20)  return false;

        return true;
    }

    public static void main(String[] args) {

        // Teste 1 - todos os campos validos -> true
        Cronometro.iniciar();
        boolean r1 = validarCadastro("Rafael", "rafael@email.com", "senha123");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 2 - nome "Jo" tem 2 chars, minimo e 3 -> false
        Cronometro.iniciar();
        boolean r2 = validarCadastro("Jo", "jo@email.com", "senha123");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 3 - senha tem 21 chars, maximo e 20 -> false
        Cronometro.iniciar();
        boolean r3 = validarCadastro("Rafael", "rafael@email.com", "senhaMuitoLongaDemais");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 4 - email "r@io" tem 4 chars, minimo e 5 -> false
        Cronometro.iniciar();
        boolean r4 = validarCadastro("Rafael", "r@io", "senha123");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");
        Cronometro.parar();

        // Teste 5 - todos nos limites minimos exatos -> true
        Cronometro.iniciar();
        boolean r5 = validarCadastro("Ana", "a@b.c", "12345678");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r5,  r5 ? "PASSOU" : "FALHOU");
        Cronometro.parar();
    }
}
