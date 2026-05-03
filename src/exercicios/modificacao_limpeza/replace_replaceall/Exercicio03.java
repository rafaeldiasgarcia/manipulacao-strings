package exercicios.modificacao_limpeza.replace_replaceall;

/**
 * Exercicio 03 - replaceAll() com caractere especial (.)
 *
 * Enunciado:
 * No Regex, o caractere ponto '.' NÃO significa ponto literal.
 * Ele significa: "qualquer caractere".
 *
 * Exemplo do bug clássico:
 * - "abc.def".replaceAll(".", "-") -> "-------" (substitui tudo!)
 *
 * Quando você quer substituir o ponto literal '.', você precisa ESCAPAR no regex.
 * E como você está em Java, precisa escapar a barra também.
 *
 * Implemente `substituirPontosPorHifen` usando `replaceAll` para trocar APENAS
 * os pontos literais '.' por '-' (hífen).
 *
 * Dica:
 * - Regex para ponto literal: \\.
 * - String Java para esse regex: "\\\\."
 *
 * Restrições:
 * - Se `texto` for null, retorne null.
 * - Se `texto` for vazio (""), retorne "".
 */
public class Exercicio03 {

    public static String substituirPontosPorHifen(String texto) {

        if (texto == null) return null;
        if (texto.isEmpty()) return "";

        return texto.replaceAll("\\.", "-");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: substituirPontosPorHifen ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Domínio simples
        String r1 = substituirPontosPorHifen("abc.def");
        String e1 = "abc-def";
        System.out.printf("Teste 1 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e1, r1, e1.equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Versão semântica
        String r2 = substituirPontosPorHifen("1.2.3");
        String e2 = "1-2-3";
        System.out.printf("Teste 2 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e2, r2, e2.equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Sem pontos (não deve mexer)
        String r3 = substituirPontosPorHifen("abcdef");
        String e3 = "abcdef";
        System.out.printf("Teste 3 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e3, r3, e3.equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 4 - Só pontos
        String r4 = substituirPontosPorHifen("...");
        String e4 = "---";
        System.out.printf("Teste 4 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e4, r4, e4.equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 5 - Vazio
        String r5 = substituirPontosPorHifen("");
        String e5 = "";
        System.out.printf("Teste 5 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e5, r5, e5.equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 6 - Null
        String r6 = substituirPontosPorHifen(null);
        System.out.printf("Teste 6 | Esperado: %-15s | Obtido: %-15s | %s%n",
                "null", String.valueOf(r6), r6 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 7 - Ponto no começo e no final
        String r7 = substituirPontosPorHifen(".a.b.");
        String e7 = "-a-b-";
        System.out.printf("Teste 7 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e7, r7, e7.equals(r7) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

