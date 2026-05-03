package exercicios.modificacao_limpeza.replace_replaceall;

/**
 * Exercicio 05 - DESAFIO: Gerador de Slug (URL Amigável)
 *
 * Enunciado:
 * Você está desenvolvendo o backend de um blog e precisa criar um conversor que 
 * pega o título de um artigo e o transforma em uma "slug" válida para a URL.
 *
 * Regras de processamento (devem ser aplicadas nesta ordem):
 * 1. Remova espaços em branco das extremidades do texto.
 * 2. Remova qualquer caractere que NÃO seja letra (a-z, A-Z), número (0-9) ou espaço em branco.
 *    -> Dica: O regex "[^a-zA-Z0-9\\s]" seleciona tudo o que for "proibido". Para remover, substitua por "".
 * 3. Substitua sequências de um ou mais espaços em branco por um único hífen "-".
 *    -> Dica: O regex "\\s+" resolve isso.
 *
 * Exemplo: 
 * Entrada: "  Java: O Guia Definitivo! (2026)  "
 * Saída:   "Java-O-Guia-Definitivo-2026"
 *
 * Restrições:
 * - Se `titulo` for null, retorne null.
 * - Se `titulo` for apenas espaços em branco, deve retornar uma string vazia "".
 */
public class Exercicio05 {

    public static String gerarSlug(String titulo) {

        if (titulo == null) return null;

        return titulo.strip()
                .replaceAll("[^a-zA-Z0-9\\s]", "")
                .strip()
                .replaceAll("\\s+", "-");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: gerarSlug ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Cenário Ideal Simples
        String r1 = gerarSlug("Ola Mundo");
        String e1 = "Ola-Mundo";
        System.out.printf("Teste 1 | Esperado: %-25s | Obtido: %-25s | %s%n",
                e1, r1, e1.equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Espaços duplos e nas pontas
        String r2 = gerarSlug("  Ola   Mundo  ");
        String e2 = "Ola-Mundo";
        System.out.printf("Teste 2 | Esperado: %-25s | Obtido: %-25s | %s%n",
                e2, r2, e2.equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Com pontuação e caracteres especiais
        String r3 = gerarSlug("Java: O Guia Definitivo!");
        String e3 = "Java-O-Guia-Definitivo";
        System.out.printf("Teste 3 | Esperado: %-25s | Obtido: %-25s | %s%n",
                e3, r3, e3.equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Símbolos no meio de palavras
        String r4 = gerarSlug("100% focado no @projeto (v2)");
        String e4 = "100-focado-no-projeto-v2";
        System.out.printf("Teste 4 | Esperado: %-25s | Obtido: %-25s | %s%n",
                e4, r4, e4.equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 5 - Só espaços e pontuação
        String r5 = gerarSlug("  !@#  $%^  ");
        String e5 = "";
        System.out.printf("Teste 5 | Esperado: %-25s | Obtido: %-25s | %s%n",
                e5, r5, e5.equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 6 - Vazio
        String r6 = gerarSlug("");
        String e6 = "";
        System.out.printf("Teste 6 | Esperado: %-25s | Obtido: %-25s | %s%n",
                e6, r6, e6.equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 7 - Null
        String r7 = gerarSlug(null);
        System.out.printf("Teste 7 | Esperado: %-25s | Obtido: %-25s | %s%n",
                "null", String.valueOf(r7), r7 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}