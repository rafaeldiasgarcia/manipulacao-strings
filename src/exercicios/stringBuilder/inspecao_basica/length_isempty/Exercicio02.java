package exercicios.stringBuilder.inspecao_basica.length_isempty;

/**
 * Exercicio 02 - Separador usando length()
 *
 * Enunciado:
 * Um sistema precisa montar uma lista com ate tres itens, separados por
 * " | ". Itens nulos ou vazios devem ser ignorados.
 *
 * Implemente o metodo `montarLista` usando StringBuilder.
 *
 * Regras:
 * 1. Se os tres itens forem "Java", "SQL", "Git", retorne "Java | SQL | Git".
 * 2. Se apenas um item for valido, retorne apenas esse item.
 * 3. Se item nulo ou vazio aparecer no meio, ele deve ser ignorado.
 * 4. Se todos forem nulos ou vazios, retorne "".
 *
 * Restricoes:
 * - Use `new StringBuilder()`.
 * - Use `length()` para decidir se ja existe conteudo antes de adicionar o separador.
 * - Use `append()` para montar o texto.
 * - Use `toString()` para retornar o resultado final.
 * - Nao use String.join().
 * - Nao use String.format().
 * - Nao use arrays ou listas neste exercicio.
 */
public class Exercicio02 {

    public static String montarLista(String item1, String item2, String item3) {

        StringBuilder builder = new StringBuilder();

        if (item1 != null && !item1.isEmpty()) {
            if (builder.length() > 0) {
                builder.append(" | ");
            }

            builder.append(item1);
        }
        if (item2 != null && !item2.isEmpty()) {
            if (builder.length() > 0) {
                builder.append(" | ");
            }

            builder.append(item2);
        }
        if (item3 != null && !item3.isEmpty()) {
            if (builder.length() > 0) {
                builder.append(" | ");
            }

            builder.append(item3);
        }

        return builder.toString();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-30s | Obtido: %-30s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: montarLista ---");

        imprimirTeste(1, "Java | SQL | Git", montarLista("Java", "SQL", "Git"));
        imprimirTeste(2, "Java", montarLista("Java", null, ""));
        imprimirTeste(3, "SQL | Git", montarLista("", "SQL", "Git"));
        imprimirTeste(4, "Java | Git", montarLista("Java", "", "Git"));
        imprimirTeste(5, "", montarLista(null, "", null));
    }
}
