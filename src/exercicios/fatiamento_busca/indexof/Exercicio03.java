package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 03 - Extrair a extensão de um arquivo
 *
 * Dado o nome de um arquivo, retorne a extensão (tudo após o último ponto).
 * Ex: "relatorio.final.pdf" → "pdf"
 *
 * Se a String for nula, não contiver ponto, ou o ponto for o último caractere, retorne null.
 *
 * Restrição: use lastIndexOf() e substring().
 */
public class Exercicio03 {

    public static String extrairExtensao(String nomeArquivo) {

        if (nomeArquivo == null) return null;

        int posicaoUltimoPonto = nomeArquivo.lastIndexOf('.');
        if (posicaoUltimoPonto == -1 || posicaoUltimoPonto == nomeArquivo.length() -1) return null;

        return nomeArquivo.substring(posicaoUltimoPonto + 1);
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 03: extrairExtensao ---");

        // Teste 1 - um ponto só → "pdf"
        String r1 = extrairExtensao("documento.pdf");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "pdf", r1, "pdf".equals(r1) ? "PASSOU" : "FALHOU");

        // Teste 2 - múltiplos pontos, pega o último → "pdf"
        String r2 = extrairExtensao("relatorio.final.pdf");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "pdf", r2, "pdf".equals(r2) ? "PASSOU" : "FALHOU");

        // Teste 3 - sem ponto → null
        String r3 = extrairExtensao("arquivo");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "null", r3, r3 == null ? "PASSOU" : "FALHOU");

        // Teste 4 - nulo → null
        String r4 = extrairExtensao(null);
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "null", r4, r4 == null ? "PASSOU" : "FALHOU");

        // Teste 5 - ponto no último caractere, sem extensão → null
        String r5 = extrairExtensao("arquivo.");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "null", r5, r5 == null ? "PASSOU" : "FALHOU");
    }
}
