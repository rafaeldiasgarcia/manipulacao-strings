package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 01 - substring() básico com 1 parâmetro
 *
 * Enunciado:
 * Você trabalha num sistema de cobrança onde o número da fatura vem atrelado
 * com um prefixo da filial onde foi gerado, cujo prefixo sempre tem o tamanho fixo de 3 letras
 * seguidas por um traço. Ex: "SAO-19348", "RIO-0029", "BHC-210499".
 *
 * Precisamos extrair APENAS a parte numérica (o id da fatura real) para salvar no banco.
 *
 * Implemente a função `obterIdFatura`, que ignora os primeiros 4 caracteres e
 * retorna do índice 4 até o final.
 *
 * Restrições:
 * - Caso a entrada seja nula, retorne nulo.
 * - Caso a entrada tenha menos que 4 caracteres, retorne vazio ("").
 */
public class Exercicio01 {

    public static String obterIdFatura(String faturaPrefixada) {

        if (faturaPrefixada == null) return null;
        if (faturaPrefixada.length() < 4) return "";

        return faturaPrefixada.substring(4);
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 01: obterIdFatura ---");

        // Teste 1 - Padrão normal
        String r1 = obterIdFatura("SAO-19348");
        System.out.printf("Teste 1 | Esperado: %-10s | Obtido: %-10s | %s%n", "19348", r1, "19348".equals(r1) ? "PASSOU" : "FALHOU");

        // Teste 2 - Padrão normal com números curtos
        String r2 = obterIdFatura("RIO-55");
        System.out.printf("Teste 2 | Esperado: %-10s | Obtido: %-10s | %s%n", "55", r2, "55".equals(r2) ? "PASSOU" : "FALHOU");

        // Teste 3 - Nada após o prefixo
        String r3 = obterIdFatura("BHC-");
        System.out.printf("Teste 3 | Esperado: %-10s | Obtido: %-10s | %s%n", "", r3, "".equals(r3) ? "PASSOU" : "FALHOU");

        // Teste 4 - String nula
        String r4 = obterIdFatura(null);
        System.out.printf("Teste 4 | Esperado: %-10s | Obtido: %-10s | %s%n", "null", String.valueOf(r4), r4 == null ? "PASSOU" : "FALHOU");

        // Teste 5 - String menor que 4 caracteres
        String r5 = obterIdFatura("XYZ");
        System.out.printf("Teste 5 | Esperado: %-10s | Obtido: %-10s | %s%n", "", r5, "".equals(r5) ? "PASSOU" : "FALHOU");
    }
}

