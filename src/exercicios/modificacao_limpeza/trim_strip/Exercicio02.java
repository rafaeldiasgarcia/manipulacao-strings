package exercicios.modificacao_limpeza.trim_strip;

/**
 * Exercicio 02 - Limpeza direcional (stripTrailing / stripLeading)
 *
 * Enunciado:
 * Às vezes, não queremos apagar os espaços de AMBOS os lados.
 * Imagine que você está processando um script Python ou um arquivo YAML,
 * onde a indentação (espaços no começo da linha) é ABSOLUTAMENTE CRÍTICA
 * e não pode ser apagada. Porém, espaços vazios "sobrando" no final da linha
 * (trailing spaces) são inúteis e devem ser limpos.
 *
 * O Java 11 introduziu métodos específicos para isso:
 * - `stripLeading()`: Limpa apenas a esquerda (começo).
 * - `stripTrailing()`: Limpa apenas a direita (final).
 *
 * Implemente a função `limparFinalDaLinha` que remove SOMENTE os espaços
 * do fim da string, preservando intactos os espaços do começo.
 *
 * Restrições:
 * - Se nulo, retorne nulo.
 */
public class Exercicio02 {

    public static String limparFinalDaLinha(String linhaCodigo) {
        
        if (linhaCodigo == null) return null;

        return linhaCodigo.stripTrailing();
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: limparFinalDaLinha ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Mantém o começo, limpa o final
        String r1 = limparFinalDaLinha("    if (x > 0):   ");
        System.out.printf("Teste 1 | Esperado: '%s' | Obtido: '%s' | %s%n",
                "    if (x > 0):", r1, "    if (x > 0):".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Sem espaços, retorna igual
        String r2 = limparFinalDaLinha("print('hello')");
        System.out.printf("Teste 2 | Esperado: '%s' | Obtido: '%s' | %s%n",
                "print('hello')", r2, "print('hello')".equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Espaços apenas no final (comporta igual ao strip/trim normal visualmente)
        String r3 = limparFinalDaLinha("return true;    \t\n");
        System.out.printf("Teste 3 | Esperado: '%s' | Obtido: '%s' | %s%n",
                "return true;", r3, "return true;".equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Nulo
        String r4 = limparFinalDaLinha(null);
        System.out.printf("Teste 4 | Esperado: 'null' | Obtido: '%s' | %s%n",
                String.valueOf(r4), r4 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Apenas espaços na string inteira (deve virar vazio)
        String r5 = limparFinalDaLinha("      ");
        System.out.printf("Teste 5 | Esperado: '' | Obtido: '%s' | %s%n",
                r5, "".equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

