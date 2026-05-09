package exercicios.conversao_formatacao.string_join;

import java.util.List;

/**
 * Exercicio 05 - Desafio Final: Linha CSV simples
 *
 * Enunciado:
 * Um sistema precisa gerar uma linha CSV simples com quatro colunas:
 * id, nome, email e perfis.
 *
 * O formato final deve ser:
 * "ID,NOME,EMAIL,PERFIL1|PERFIL2|PERFIL3"
 *
 * Regras:
 * 1. A linha principal deve usar virgula como separador.
 * 2. A lista de perfis deve usar pipe "|" como separador.
 * 3. Se nome for null, use uma string vazia "".
 * 4. Se email for null, use uma string vazia "".
 * 5. Se perfis for null, use uma string vazia "".
 * 6. Se perfis for uma lista vazia, o trecho de perfis tambem deve ser "".
 *
 * Restricoes:
 * - Use `String.join("|", perfis)` para juntar os perfis quando a lista nao for null.
 * - Use `String.join(",", ...)` para montar a linha final.
 * - Nao use StringBuilder.
 * - Nao use String.format().
 */
public class Exercicio05 {

    public static String gerarLinhaCsv(String id, String nome, String email, List<String> perfis) {

        if (nome == null) {
            nome = "";
        }
        if (email == null) {
            email = "";
        }
        if (perfis == null) {
            perfis = List.of();
        }

        String perfisFormatados = String.join("|", perfis);

        return String.join(",", id, nome, email, perfisFormatados);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-55s | Obtido: %-55s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: gerarLinhaCsv ---");

        imprimirTeste(1,
                "1,Rafael,rafael@email.com,ADMIN|USER",
                gerarLinhaCsv("1", "Rafael", "rafael@email.com", List.of("ADMIN", "USER")));

        imprimirTeste(2,
                "2,Ana,ana@email.com,USER",
                gerarLinhaCsv("2", "Ana", "ana@email.com", List.of("USER")));

        imprimirTeste(3,
                "3,,semnome@email.com,CLIENTE",
                gerarLinhaCsv("3", null, "semnome@email.com", List.of("CLIENTE")));

        imprimirTeste(4,
                "4,Sem Email,,ADMIN",
                gerarLinhaCsv("4", "Sem Email", null, List.of("ADMIN")));

        imprimirTeste(5,
                "5,Sem Perfis,semperfis@email.com,",
                gerarLinhaCsv("5", "Sem Perfis", "semperfis@email.com", null));

        imprimirTeste(6,
                "6,Lista Vazia,vazia@email.com,",
                gerarLinhaCsv("6", "Lista Vazia", "vazia@email.com", List.of()));

        imprimirTeste(7,
                "null,null-id@email.com,TESTE,DEV|QA",
                gerarLinhaCsv(null, "null-id@email.com", "TESTE", List.of("DEV", "QA")));
    }
}
