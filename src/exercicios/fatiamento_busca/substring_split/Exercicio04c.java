package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 04c - split() com parâmetro de limite positivo
 *
 * Enunciado:
 * Outro uso poderoso do `split(regex, limit)` é quando o limite é positivo (ex: `2`).
 * O limite controla o número MÁXIMO de pedaços. Isso é muito usado para parsear
 * arquivos contendo o clássico chave/valor ("chave=valor"), onde o próprio valor
 * pode conter o símbolo '=' dentro dele e não gostaríamos que ele fosse quebrado!
 *
 * Ex: `url=jdbc:mysql://localhost=3306` deve ser separado no `split("=", 2)` assim:
 * ["url", "jdbc:mysql://localhost=3306"]. Se usássemos limit como 0 padrão, a
 * string ali dentro seria quebrada onde não deveria.
 *
 * Implemente `separarCabecalho` que recebe uma string no formato "Header: Valor",
 * e usa split com limite 2 no separador ": " para retornar exatamente chave no índice 0
 * e valor no índice 1.
 *
 * Restrições:
 * - Se for nulo ou não contiver ": ", retorne array vazio.
 * - Caso tenha ": ", a assinatura deve retornar ["Chave", "O resto todo com: e sem:"].
 */
public class Exercicio04c {

    public static String[] separarCabecalho(String headerConfig) {

        if (headerConfig == null || !headerConfig.contains(":")) return new String[0];

        return headerConfig.split(": ", 2);
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04c: separarCabecalho ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Normal em string com múltiplos ": "
        String[] r1 = separarCabecalho("Authorization: Bearer abc:def:123");
        boolean t1 = r1 != null && r1.length == 2 && "Authorization".equals(r1[0]) && "Bearer abc:def:123".equals(r1[1]);
        System.out.printf("Teste 1 | Esperado %d | Obtido: %d | %s%n", 2, r1 != null ? r1.length : -1, t1 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Simples sem repetições
        String[] r2 = separarCabecalho("Host: localhost");
        boolean t2 = r2 != null && r2.length == 2 && "Host".equals(r2[0]) && "localhost".equals(r2[1]);
        System.out.printf("Teste 2 | Esperado %d | Obtido: %d | %s%n", 2, r2 != null ? r2.length : -1, t2 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Nada após os dois pontos
        String[] r3 = separarCabecalho("X-Vazia: ");
        boolean t3 = r3 != null && r3.length == 2 && "X-Vazia".equals(r3[0]) && "".equals(r3[1]);
        System.out.printf("Teste 3 | Esperado %d | Obtido %d e '%s' | %s%n", 2, r3 != null ? r3.length : -1, r3 != null && r3.length > 1 ? r3[1] : "-", t3 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Formato inválido (sem ": ")
        String[] r4 = separarCabecalho("Invalido;Valor");
        boolean t4 = r4 != null && r4.length == 0;
        System.out.printf("Teste 4 | Esperado %d | Obtido: %d | %s%n", 0, r4 != null ? r4.length : -1, t4 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Nulo
        String[] r5 = separarCabecalho(null);
        boolean t5 = r5 != null && r5.length == 0;
        System.out.printf("Teste 5 | Esperado %d | Obtido: %d | %s%n", 0, r5 != null ? r5.length : -1, t5 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
