package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 04a - substring() dinâmico interagindo com lastIndexOf()
 * <p>
 * Enunciado:
 * É muito comum precisarmos extrair a extensão de um arquivo. O problema é que
 * arquivos podem ter múltiplos pontos no nome, como "backup.tar.gz" ou "script.min.js".
 * A verdadeira extensão é sempre o que vem APÓS o ÚLTIMO ponto.
 * <p>
 * Implemente a função `extrairExtensao` que recebe o nome de um arquivo e
 * retorna apenas a sua extensão final, sem o ponto.
 * <p>
 * Restrições:
 * - Se nulo, retorne nulo.
 * - Se não tiver ponto, retorne uma string vazia ("").
 * - Se o ponto for o último caractere (ex: "arquivo."), retorne uma string vazia ("").
 */
public class Exercicio04a {

    public static String extrairExtensao(String nomeArquivo) {

        if (nomeArquivo == null) return null;
        int posicaoPonto = nomeArquivo.lastIndexOf('.');
        int ultimaBarra = nomeArquivo.lastIndexOf('/');
        if (posicaoPonto == -1 || posicaoPonto < ultimaBarra) return "";

        return nomeArquivo.substring(posicaoPonto + 1);
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04a: extrairExtensao ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        String r1 = extrairExtensao("documento.pdf");
        System.out.printf("Teste 1 | Esperado: %-7s | Obtido: %-7s | %s%n", "pdf", r1, "pdf".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r2 = extrairExtensao("arquivo.min.js");
        System.out.printf("Teste 2 | Esperado: %-7s | Obtido: %-7s | %s%n", "js", r2, "js".equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r3 = extrairExtensao("sem_extensao");
        System.out.printf("Teste 3 | Esperado: %-7s | Obtido: %-7s | %s%n", "", r3, "".equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r4 = extrairExtensao(".gitignore");
        System.out.printf("Teste 4 | Esperado: %-7s | Obtido: %-7s | %s%n", "gitignore", r4, "gitignore".equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r5 = extrairExtensao("pasta_com_ponto./arquivo");
        System.out.printf("Teste 5 | Esperado: %-7s | Obtido: %-7s | %s%n", "", r5, "".equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r6 = extrairExtensao(null);
        System.out.printf("Teste 6 | Esperado: %-7s | Obtido: %-7s | %s%n", "null", String.valueOf(r6), r6 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
