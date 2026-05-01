package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 03 - split() básico
 * <p>
 * Enunciado:
 * O comando `split(String regex)` é essencial para separar elementos de um texto
 * baseados em um delimitador (como vírgula, ponto e vírgula, espaço, etc).
 * <p>
 * Implemente a função `separarTags` que recebe uma string com tags separadas
 * por vírgula (ex: "java,spring,aws") e devolve um array de Strings (String[])
 * contendo cada tag como um elemento.
 * <p>
 * Restrições e Dicas (Armadilhas do Java):
 * - Se a string for nula, retorne um array vazio: `new String[0]`.
 * - Se a string for vazia (ex: ""), o `split` nativo do Java estranhamente
 * retorna um array com 1 elemento vazio `[""]`. Contorne isso validando
 * para retornar `new String[0]` também caso a string seja vazia!
 */
public class Exercicio03 {

    public static String[] separarTags(String linhaTags) {

        if (linhaTags == null || linhaTags.isEmpty()) return new String[0];

        return linhaTags.split(",");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 03: separarTags ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Padrão normal
        String[] r1 = separarTags("java,spring,aws");
        boolean t1 = r1 != null && r1.length == 3 && "spring".equals(r1[1]);
        System.out.printf("Teste 1 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 3, r1 != null ? r1.length : -1, t1 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Sem delimitador (apenas 1 elemento)
        String[] r2 = separarTags("backend");
        boolean t2 = r2 != null && r2.length == 1 && "backend".equals(r2[0]);
        System.out.printf("Teste 2 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 1, r2 != null ? r2.length : -1, t2 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Nulo
        String[] r3 = separarTags(null);
        boolean t3 = r3 != null && r3.length == 0;
        System.out.printf("Teste 3 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 0, r3 != null ? r3.length : -1, t3 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Vazio
        String[] r4 = separarTags("");
        boolean t4 = r4 != null && r4.length == 0;
        System.out.printf("Teste 4 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 0, r4 != null ? r4.length : -1, t4 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Espaços mantidos pelo split básico
        String[] r5 = separarTags(" api , rest ");
        boolean t5 = r5 != null && r5.length == 2 && " rest ".equals(r5[1]);
        System.out.printf("Teste 5 | Esperado valor \"%s\" | Obtido \"%s\" | %s%n", " rest ", (r5 != null && r5.length == 2) ? r5[1] : "", t5 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 6 - Vírgula no final (comportamento padrão do Java é ignorar o vazio final)
        String[] r6 = separarTags("java,");
        boolean t6 = r6 != null && r6.length == 1 && "java".equals(r6[0]);
        System.out.printf("Teste 6 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 1, r6 != null ? r6.length : -1, t6 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 7 - Várias vírgulas seguidas (gera elementos vazios no meio)
        String[] r7 = separarTags("java,,aws");
        boolean t7 = r7 != null && r7.length == 3 && "".equals(r7[1]);
        System.out.printf("Teste 7 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 3, r7 != null ? r7.length : -1, t7 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 8 - Apenas vírgulas (comportamento padrão descarta tudo vazio do final)
        String[] r8 = separarTags(",,");
        boolean t8 = r8 != null && r8.length == 0;
        System.out.printf("Teste 8 | Esperado tamanho %d | Obtido tamanho %d | %s%n", 0, r8 != null ? r8.length : -1, t8 ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
