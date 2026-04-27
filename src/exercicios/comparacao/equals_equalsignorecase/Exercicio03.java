package exercicios.comparacao.equals_equalsignorecase;

import java.util.Objects;

/**
 * Exercicio 03 - Misturando equals e equalsIgnoreCase
 *
 * Enunciado:
 * Implemente a função `validarAcesso` que verifica as credenciais de um usuário.
 * Regras:
 * 1. O e-mail NÃO é case-sensitive (ex: "Rafael@email.com" deve ser aceito como igual a "rafael@email.com").
 * 2. A senha É case-sensitive (ex: "Senha123" é diferente de "senha123").
 * A função só deve retornar true se AMBOS, e-mail e senha, forem válidos de acordo com as regras acima.
 * 
 * Restricao: O sistema pode passar valores nulos (tanto do usuário quanto do banco). Trate para evitar NullPointerException!
 */
public class Exercicio03 {

    public static boolean validarAcesso(String emailDigitado, String senhaDigitada, String emailCadastrado, String senhaCadastrada) {
        
        return emailCadastrado != null && emailCadastrado.equalsIgnoreCase(emailDigitado)
            && Objects.equals(senhaCadastrada, senhaDigitada);
    }

    public static void main(String[] args) {

        // Teste 1 - tudo exato -> true
        boolean r1 = validarAcesso("user@email.com", "senha123", "user@email.com", "senha123");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - email com maiusculas (valido), senha exata (valido) -> true
        boolean r2 = validarAcesso("USER@email.com", "senha123", "user@email.com", "senha123");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r2, r2 == true ? "PASSOU" : "FALHOU");

        // Teste 3 - email exato (valido), senha com maiuscula (invalido) -> false
        boolean r3 = validarAcesso("user@email.com", "Senha123", "user@email.com", "senha123");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r3, r3 == false ? "PASSOU" : "FALHOU");

        // Teste 4 - email errado, senha exata -> false
        boolean r4 = validarAcesso("admin@email.com", "senha123", "user@email.com", "senha123");
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r4, r4 == false ? "PASSOU" : "FALHOU");

        // Teste 5 - email com maiusculas (valido) e senha com maiusculas (invalido) -> false
        boolean r5 = validarAcesso("User@Email.com", "SENHA123", "user@email.com", "senha123");
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r5, r5 == false ? "PASSOU" : "FALHOU");

        // Teste 6 - email digitado como null -> false
        boolean r6 = validarAcesso(null, "senha123", "user@email.com", "senha123");
        System.out.printf("Teste 6 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r6, r6 == false ? "PASSOU" : "FALHOU");

        // Teste 7 - senha cadastrada no banco é null -> false
        boolean r7 = validarAcesso("user@email.com", "senha123", "user@email.com", null);
        System.out.printf("Teste 7 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r7, r7 == false ? "PASSOU" : "FALHOU");
    }
}
