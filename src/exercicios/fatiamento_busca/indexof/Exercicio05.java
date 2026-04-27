package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 05 (Desafio Final) - Parser de par chave=valor
 *
 * Sistemas de configuração frequentemente usam o formato "chave=valor".
 * Uma linha pode conter várias entradas separadas por ponto e vírgula:
 *
 *   "host=localhost;porta=5432;banco=meubanco"
 *
 * Implemente `buscarValor` que recebe a linha de configuração e uma chave,
 * e retorna o valor correspondente.
 *
 * Regras:
 * 1. A chave sempre é seguida de '=' e termina no próximo ';' ou no fim da String.
 * 2. Se a chave não existir, retorne null.
 * 3. Se qualquer argumento for nulo, retorne null.
 *
 * Ex: buscarValor("host=localhost;porta=5432", "host")   → "localhost"
 *     buscarValor("host=localhost;porta=5432", "porta")  → "5432"
 *     buscarValor("host=localhost;porta=5432", "banco")  → null
 *
 * Restrição: use indexOf() e substring() — sem split().
 */
public class Exercicio05 {

    public static String buscarValor(String config, String chave) {

        if (config == null || chave == null) return null;

        String busca = chave + "=";
        int posicao = 0;

        while ((posicao = config.indexOf(busca, posicao)) != -1) {

            if (posicao == 0 || config.charAt(posicao - 1) == ';') {

                int inicioValor = posicao + busca.length();
                int fimValor = config.indexOf(';', inicioValor);

                if (fimValor == -1) {
                    fimValor = config.length();
                }

                return config.substring(inicioValor, fimValor);
            }

            posicao += busca.length();
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 05: buscarValor ---");

        String config = "host=localhost;porta=5432;banco=meubanco";

        // Teste 1 - chave no início → "localhost"
        String r1 = buscarValor(config, "host");
        System.out.printf("Teste 1 | Esperado: %-12s | Obtido: %-12s | %s%n", "localhost", r1, "localhost".equals(r1) ? "PASSOU" : "FALHOU");

        // Teste 2 - chave no meio → "5432"
        String r2 = buscarValor(config, "porta");
        System.out.printf("Teste 2 | Esperado: %-12s | Obtido: %-12s | %s%n", "5432", r2, "5432".equals(r2) ? "PASSOU" : "FALHOU");

        // Teste 3 - chave no fim (sem ';' depois) → "meubanco"
        String r3 = buscarValor(config, "banco");
        System.out.printf("Teste 3 | Esperado: %-12s | Obtido: %-12s | %s%n", "meubanco", r3, "meubanco".equals(r3) ? "PASSOU" : "FALHOU");

        // Teste 4 - chave inexistente → null
        String r4 = buscarValor(config, "usuario");
        System.out.printf("Teste 4 | Esperado: %-12s | Obtido: %-12s | %s%n", "null", r4, r4 == null ? "PASSOU" : "FALHOU");

        // Teste 5 - argumento nulo → null
        String r5 = buscarValor(null, "host");
        System.out.printf("Teste 5 | Esperado: %-12s | Obtido: %-12s | %s%n", "null", r5, r5 == null ? "PASSOU" : "FALHOU");
    }
}
