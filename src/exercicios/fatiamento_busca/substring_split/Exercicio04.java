package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 04 - split() com parâmetro de limite (limit)
 * <p>
 * Enunciado:
 * Como você viu no Exercício 03, o comportamento padrão do Java para o `split(",")`
 * é CORTAR fora todos os valores vazios que estiverem no FINAL da string.
 * Ex: "a,b,c,," vira ["a", "b", "c"].
 * <p>
 * Mas imagine que você está processando um CSV onde essas vírgulas finais
 * representam colunas que o usuário deixou em branco. Nós PRECISÂMOS dessas posições
 * vazias no array para manter a conta das colunas certa!
 * <p>
 * O Java resolve isso com a sobrecarga `split(String regex, int limit)`.
 * Se você passar um número negativo (ex: -1) como limite, ele será forçado a
 * preservar (não descartar) as posições vazias no final!
 * <p>
 * Implemente `processarLinhaCsv` que recebe uma linha separada por vírgula
 * e use esse poder do "limit" para garantir que nenhum dado final seja ignorado.
 * <p>
 * Restrições:
 * - Se nulo ou vazio, retorne array de tamanho 0.
 */
public class Exercicio04 {

    public static String[] processarLinhaCsv(String linhaCsv) {

        if (linhaCsv == null || linhaCsv.isEmpty()) return new String[0];

        return linhaCsv.split(",", -1);
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04: processarLinhaCsv ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Com colunas vazias no final
        String[] r1 = processarLinhaCsv("a,b,c,,");
        boolean t1 = r1 != null && r1.length == 5 && "".equals(r1[4]);
        System.out.printf("Teste 1 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 5, r1 != null ? r1.length : -1, t1 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Normal
        String[] r2 = processarLinhaCsv("nome,email,senha");
        boolean t2 = r2 != null && r2.length == 3;
        System.out.printf("Teste 2 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 3, r2 != null ? r2.length : -1, t2 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Apenas vírgulas
        String[] r3 = processarLinhaCsv(",,");
        boolean t3 = r3 != null && r3.length == 3; // 2 virgulas representam 3 campos vazios!
        System.out.printf("Teste 3 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 3, r3 != null ? r3.length : -1, t3 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Nulo
        String[] r4 = processarLinhaCsv(null);
        boolean t4 = r4 != null && r4.length == 0;
        System.out.printf("Teste 4 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 0, r4 != null ? r4.length : -1, t4 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Vazia
        String[] r5 = processarLinhaCsv("");
        boolean t5 = r5 != null && r5.length == 0;
        System.out.printf("Teste 5 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 0, r5 != null ? r5.length : -1, t5 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
