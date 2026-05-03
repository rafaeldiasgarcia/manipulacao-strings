package exercicios.modificacao_limpeza.trim_strip;

/**
 * Exercicio 04 - Sanitização real de API (isBlank + strip)
 *
 * Enunciado:
 * Este é um dos padrões mais comuns em aplicações do mundo real.
 * Frequentemente, o frontend manda payloads JSON com campos preenchidos
 * apenas por espaços ("   "), o que tecnicamente não é nulo e não é vazio (length > 0).
 * Se gravarmos isso no Banco de Dados consumirá recursos e quebrará pesquisas futuras!
 *
 * Implemente a função `sanitizarCampo` que funciona como uma barreira protetora:
 * 1. Se a string recebida for nula, retorne null.
 * 2. Se a string consistir de APENAS espaços em branco (dica: isBlank!), retorne null.
 * 3. Caso contrário, retorne a string limpa nas bordas com `strip()`.
 */
public class Exercicio04 {

    public static String sanitizarCampo(String campo) {

        if (campo == null || campo.isBlank()) return null;

        return campo.strip();
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04: sanitizarCampo ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - String normal com pontas sujas
        String r1 = sanitizarCampo("  Rafael  ");
        System.out.printf("Teste 1 | Esperado: %-15s | Obtido: %-15s | %s%n", "Rafael", r1, "Rafael".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - String contendo Apenas espaços (deve virar null)
        String r2 = sanitizarCampo("      ");
        System.out.printf("Teste 2 | Esperado: %-15s | Obtido: %-15s | %s%n", "null", String.valueOf(r2), r2 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Null raiz (deve manter null)
        String r3 = sanitizarCampo(null);
        System.out.printf("Teste 3 | Esperado: %-15s | Obtido: %-15s | %s%n", "null", String.valueOf(r3), r3 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - String absolutamente Vazia (deve virar null)
        String r4 = sanitizarCampo("");
        System.out.printf("Teste 4 | Esperado: %-15s | Obtido: %-15s | %s%n", "null", String.valueOf(r4), r4 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Sem espaços para limpar
        String r5 = sanitizarCampo("admin");
        System.out.printf("Teste 5 | Esperado: %-15s | Obtido: %-15s | %s%n", "admin", r5, "admin".equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge Case 6 - String com espaços Unicode no meio (não devem sumir) e bordas para limpar
        String r6 = sanitizarCampo("\t João \u2003 Silva \n");
        System.out.printf("Teste 6 | Esperado: %-15s | Obtido: %-15s | %s%n", "João \u2003 Silva", r6, "João \u2003 Silva".equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge Case 7 - Objeto já perfeitamente sanitizado previamente pelo frontend
        String r7 = sanitizarCampo("OK");
        System.out.printf("Teste 7 | Esperado: %-15s | Obtido: %-15s | %s%n", "OK", r7, "OK".equals(r7) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
