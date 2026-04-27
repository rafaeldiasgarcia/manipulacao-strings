package exercicios.comparacao.equals_equalsignorecase;

import java.util.Objects;

/**
 * Exercicio 05 (Desafio Final) - O Guardião do Banco de Dados
 *
 * Enunciado:
 * Você precisa criar uma função de autorização. O sistema recebe o nível de acesso do 
 * usuário e a ação que ele quer realizar.
 * 
 * Regras de Autorização:
 * 1. O Nível de Acesso ("ADMIN" ou "USER") DEVE ser digitado de forma exata (case-sensitive).
 *    Se vier "admin" minúsculo, não tem acesso.
 * 
 * 2. Se for "ADMIN", ele tem permissão para realizar as ações "DELETAR" ou "ATUALIZAR".
 *    (O nome das ações é case-insensitive, ou seja, "Deletar", "deletar", etc, são válidos).
 * 
 * 3. Se for "USER", ele tem permissão apenas para realizar a ação "LER".
 *    (O nome da ação também é case-insensitive).
 * 
 * Implemente a função `autorizar` que deve retornar `true` apenas se as regras baterem.
 * 
 * Restricao: Tanto `nivelAcesso` quanto `acao` podem ser `null`. Faça um código blindado!
 */
public class Exercicio05 {

    public static boolean autorizar(String nivelAcesso, String acao) {

        if ("ADMIN".equals(nivelAcesso)) {

            return "DELETAR".equalsIgnoreCase(acao) || "ATUALIZAR".equalsIgnoreCase(acao);
        }

        if ("USER".equals(nivelAcesso)) {

            return "LER".equalsIgnoreCase(acao);
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 05: O Guardião ---");

        // Teste 1 - ADMIN correto, DELETAR correto (tudo maiusculo) -> true
        boolean r1 = autorizar("ADMIN", "DELETAR");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - ADMIN correto, atualizar minusculo -> true
        boolean r2 = autorizar("ADMIN", "atualizar");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r2, r2 == true ? "PASSOU" : "FALHOU");

        // Teste 3 - admin minusculo (invalido), DELETAR correto -> false
        boolean r3 = autorizar("admin", "DELETAR");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r3, r3 == false ? "PASSOU" : "FALHOU");

        // Teste 4 - USER correto, lEr misturado -> true
        boolean r4 = autorizar("USER", "lEr");
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r4, r4 == true ? "PASSOU" : "FALHOU");

        // Teste 5 - USER correto, DELETAR -> false (USER nao pode deletar)
        boolean r5 = autorizar("USER", "DELETAR");
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r5, r5 == false ? "PASSOU" : "FALHOU");

        // Teste 6 - Nulo no nivel -> false
        boolean r6 = autorizar(null, "LER");
        System.out.printf("Teste 6 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r6, r6 == false ? "PASSOU" : "FALHOU");

        // Teste 7 - ADMIN correto, Nulo na acao -> false
        boolean r7 = autorizar("ADMIN", null);
        System.out.printf("Teste 7 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r7, r7 == false ? "PASSOU" : "FALHOU");
    }
}
