package exercicios.modificacao_limpeza.trim_strip;

/**
 * Exercicio 03 - stripIndent() (Limpeza em bloco multilinhas)
 *
 * Enunciado:
 * A partir do Java 15, foi introduzido o poderoso `stripIndent()`.
 * Ele pega uma String que possui múltiplas linhas, calcula qual é a indentação
 * ACIDENTAL comum a todas elas, e remove apenas esse "excesso" da esquerda.
 *
 * Exemplo visual:
 * """
 *       linha1
 *         linha2
 *       linha3
 * """
 * O `stripIndent()` vai descobrir que TODAS as linhas têm pelo menos 6 espaços
 * de recuo acidental, e vai remover exatamente esses 6 espaços (preservando o
 * recuo extra intencional da linha 2).
 *
 * Implemente `limparBlocoDeTexto` que recebe uma string multilinhas e
 * chame esse método para extrair a indentação excedente, usando `stripIndent()`.
 * Use também o `.stripTrailing()` logo em seguida (encadeado) para garantir
 * que não sobrem eventuais espaços perdidos no final do bloco.
 *
 * Restrições:
 * - Se nulo, retorne nulo.
 */
public class Exercicio03 {

    public static String limparBlocoDeTexto(String bloco) {

        if (bloco == null) return null;

        return bloco.stripIndent().stripTrailing();
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: limparBlocoDeTexto ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Recuo misto normal
        String t1In = "   linha1\n      linha2\n   linha3   ";
        String t1Out = limparBlocoDeTexto(t1In);
        String t1Exp = "linha1\n   linha2\nlinha3";
        boolean b1 = t1Exp.equals(t1Out);
        System.out.printf("Teste 1 | Esperado: %-25s | Obtido: %-25s | %s%n",
                t1Exp.replace("\n", "\\n"), t1Out != null ? t1Out.replace("\n", "\\n") : "null", b1 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Json identado do mundo real
        String t2In = "    {\n      \"id\": 1\n    }    ";
        String t2Out = limparBlocoDeTexto(t2In);
        String t2Exp = "{\n  \"id\": 1\n}";
        boolean b2 = t2Exp.equals(t2Out);
        System.out.printf("Teste 2 | Esperado: %-25s | Obtido: %-25s | %s%n",
                t2Exp.replace("\n", "\\n"), t2Out != null ? t2Out.replace("\n", "\\n") : "null", b2 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Bloco sem indentação extra
        String t3In = "linha1\nlinha2";
        String t3Out = limparBlocoDeTexto(t3In);
        String t3Exp = "linha1\nlinha2";
        boolean b3 = t3Exp.equals(t3Out);
        System.out.printf("Teste 3 | Esperado: %-25s | Obtido: %-25s | %s%n",
                t3Exp.replace("\n", "\\n"), t3Out != null ? t3Out.replace("\n", "\\n") : "null", b3 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Nulo
        String t4Out = limparBlocoDeTexto(null);
        boolean b4 = t4Out == null;
        System.out.printf("Teste 4 | Esperado: %-25s | Obtido: %-25s | %s%n",
                "null", String.valueOf(t4Out), b4 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Tudo vazio
        String t5Out = limparBlocoDeTexto("      ");
        boolean b5 = "".equals(t5Out);
        System.out.printf("Teste 5 | Esperado: %-25s | Obtido: %-25s | %s%n",
                "", t5Out != null ? t5Out : "null", b5 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
