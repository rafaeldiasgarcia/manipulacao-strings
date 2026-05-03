package exercicios.modificacao_limpeza.trim_strip;

/**
 * Exercicio 05 - Desafio Final: Extração com Limpeza (Substrings + Strip)
 *
 * Enunciado:
 * Estamos recebendo de um sistema legado um arquivo de logs muito sujo.
 * Cada linha do log vem no formato:
 * "    [TAG]      MENSAGEM AQUI       "
 *
 * Exemplo real:
 * "   [ERROR]    Falha conexao no banco de dados!    \n"
 *
 * O seu objetivo é extrair APENAS a mensagem fatiada que vem após o colchete ']'
 * e garantir que essa mensagem saia sem espaços inúteis nas bordas!
 *
 * Implemente `extrairMensagemLimpa` que:
 * 1. Encontra onde termina a tag (busque o caractere ']').
 * 2. Extrai a substring a partir desse ponto.
 * 3. Retorna essa substring perfeitamente `strip()ada`.
 *
 * Restrições e Tratamentos:
 * - Se for nulo ou puramente vazio (isBlank), retorne uma string vazia "".
 * - Se não houver o caractere ']' na linha, considere a linha inteira como mensagem e retorne ela limpa.
 */
public class Exercicio05 {

    public static String extrairMensagemLimpa(String linhaLog) {

        if (linhaLog == null || linhaLog.isBlank()) return "";

        int pos = linhaLog.indexOf(']');

        return linhaLog.substring(pos + 1).strip();
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: extrairMensagemLimpa ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Padrão normal (espaços antes e depois da mensagem e na tag)
        String r1 = extrairMensagemLimpa("   [ERROR]    Falha conexao!    ");
        System.out.printf("Teste 1 | Esperado: %-25s | Obtido: %-25s | %s%n", "Falha conexao!", r1, "Falha conexao!".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Sem espaços no miolo, mas tem no final
        String r2 = extrairMensagemLimpa("[INFO]Sistema iniciado.  \n");
        System.out.printf("Teste 2 | Esperado: %-25s | Obtido: %-25s | %s%n", "Sistema iniciado.", r2, "Sistema iniciado.".equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge Case 3 - Mensagem vazia após a tag
        String r3 = extrairMensagemLimpa("  [DEBUG]     ");
        System.out.printf("Teste 3 | Esperado: %-25s | Obtido: %-25s | %s%n", "", r3, "".equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge Case 4 - Formato quebrado sem a tag inteira (ignora colchete, limpa a linha e devolve)
        String r4 = extrairMensagemLimpa("  Falha critica sem tag configurada  \n");
        System.out.printf("Teste 4 | Esperado: %-25s | Obtido: %-25s | %s%n", "Falha critica sem tag configurada", r4, "Falha critica sem tag configurada".equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge Case 5 - String Vazia/Só espaços
        String r5 = extrairMensagemLimpa("\t\t  \n");
        System.out.printf("Teste 5 | Esperado: %-25s | Obtido: %-25s | %s%n", "", r5, "".equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge Case 6 - Nulo
        String r6 = extrairMensagemLimpa(null);
        System.out.printf("Teste 6 | Esperado: %-25s | Obtido: %-25s | %s%n", "", r6, "".equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

