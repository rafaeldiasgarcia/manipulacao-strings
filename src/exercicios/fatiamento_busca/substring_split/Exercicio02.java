package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 02 - substring() com dois parâmetros (beginIndex e endIndex)
 *
 * Enunciado:
 * Imagine que temos logs no formato "[INFO] Mensagem" ou "[ERROR] Falha no sistema".
 * Precisamos de uma função que extraia apenas o que está dentro dos colchetes
 * para descobrir o nível de severidade (INFO, ERROR, WARN, etc).
 *
 * Implemente a função `extrairNivelLog` onde você sabe que o colchete de abertura '['
 * está sempre na posição 0, e você deve primeiro localizar em qual índice está o
 * colchete de fechamento ']'. Depois, use esse índice com `substring(begin, end)`
 * para retornar o nível sem os colchetes.
 *
 * Restrições:
 * - Se a string for nula, retorne nulo.
 * - Se não começar com '[' ou não tiver fechamento ']', retorne a string limpa (vazia "").
 * - Dica: Use o `indexOf("]")` aprendido nos comandos anteriores para achar o endIndex!
 */
public class Exercicio02 {

    public static String extrairNivelLog(String linhaLog) {

        if (linhaLog == null) return null;
        if (!linhaLog.startsWith("[")) return "";

        int posicaoColcheteFechamento = linhaLog.indexOf(']');
        if (posicaoColcheteFechamento == -1) return "";

        return linhaLog.substring(1, posicaoColcheteFechamento);
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: extrairNivelLog ---");

        String r1 = extrairNivelLog("[INFO] Sistema iniciado com sucesso.");
        System.out.printf("Teste 1 | Esperado: %-7s | Obtido: %-7s | %s%n", "INFO", r1, "INFO".equals(r1) ? "PASSOU" : "FALHOU");

        String r2 = extrairNivelLog("[ERROR] Conexão com banco recusada!");
        System.out.printf("Teste 2 | Esperado: %-7s | Obtido: %-7s | %s%n", "ERROR", r2, "ERROR".equals(r2) ? "PASSOU" : "FALHOU");

        String r3 = extrairNivelLog("Sem colchete de abertura");
        System.out.printf("Teste 3 | Esperado: %-7s | Obtido: %-7s | %s%n", "", r3, "".equals(r3) ? "PASSOU" : "FALHOU");

        String r4 = extrairNivelLog("[WARN Faltou o fechamento");
        System.out.printf("Teste 4 | Esperado: %-7s | Obtido: %-7s | %s%n", "", r4, "".equals(r4) ? "PASSOU" : "FALHOU");

        String r5 = extrairNivelLog(null);
        System.out.printf("Teste 5 | Esperado: %-7s | Obtido: %-7s | %s%n", "null", String.valueOf(r5), r5 == null ? "PASSOU" : "FALHOU");
    }
}
