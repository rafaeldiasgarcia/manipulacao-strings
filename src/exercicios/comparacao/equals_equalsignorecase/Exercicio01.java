package exercicios.comparacao.equals_equalsignorecase;

import java.util.Objects;

/**
 * Exercicio 01 - equals()
 *
 * Enunciado:
 * Implemente o método `validarSenhaExata` que recebe uma senha digitada pelo usuário e a senha real cadastrada.
 * O método deve retornar true apenas se a senha digitada for EXATAMENTE igual à senha cadastrada, 
 * respeitando maiúsculas e minúsculas.
 *
 */
public class Exercicio01 {

    public static boolean validarSenhaExata(String senhaDigitada, String senhaCadastrada) {

        return Objects.equals(senhaDigitada, senhaCadastrada);
    }

    public static void main(String[] args) {

        // Teste 1 - senha exata -> true
        boolean r1 = validarSenhaExata("senha123", "senha123");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - primeira letra maiuscula difere -> false
        boolean r2 = validarSenhaExata("Senha123", "senha123");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r2, r2 == false ? "PASSOU" : "FALHOU");

        // Teste 3 - tamanho diferente -> false
        boolean r3 = validarSenhaExata("senha123", "senha1234");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r3, r3 == false ? "PASSOU" : "FALHOU");

        // Teste 4 - ambas vazias -> true
        boolean r4 = validarSenhaExata("", "");
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r4, r4 == true ? "PASSOU" : "FALHOU");

        // Teste 5 - palavras totalmente diferentes -> false
        boolean r5 = validarSenhaExata("admin", "root");
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r5, r5 == false ? "PASSOU" : "FALHOU");
    }
}
