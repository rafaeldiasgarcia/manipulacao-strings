package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 05 - Desafio Final: Extração Avançada
 *
 * Enunciado:
 * Chegamos ao clássico desafio de infraestrutura da vida de um desenvolvedor Java:
 * Extrair propriedades do meio de uma "Connection String" de banco de dados.
 *
 * Formato padrão: "jdbc:mysql://[host]:[port]/[database_nome]?[parametros]"
 *
 * Exemplo de entrada: "jdbc:mysql://localhost:3306/faturamento?user=root"
 * Resultado esperado: "faturamento"
 *
 * Sua missão é fatiar essa String para resgatar APENAS o nome do banco.
 * O nome do banco de dados sempre começa na TERCEIRA barra '/' na string (após porta)
 * e termina no sinal de interrogação '?' (se a string de conexão contiver parâmetros)
 * OU vai até o final da URL (se não tiver parâmetros configurados).
 *
 * Restrições:
 * - Se for nulo ou se não contiver o prefixo "jdbc:", retorne string vazia.
 * - Caso não encontre a terceira barra (url malformada), retorne string vazia.
 */
public class Exercicio05 {

    public static String extrairNomeBanco(String urlDb) {

        if (urlDb == null || !urlDb.startsWith("jdbc:")) return "";

        int posicaoDuasBarras = urlDb.indexOf("//");
        if (posicaoDuasBarras == -1) return "";

        int posicaoTerceiraBarra = urlDb.indexOf('/', posicaoDuasBarras + 2);

        if (posicaoTerceiraBarra == -1) return "";

        int posicaoInterrogacao = urlDb.indexOf('?');

        if (posicaoInterrogacao != -1) {
            return urlDb.substring(posicaoTerceiraBarra + 1, posicaoInterrogacao);
        } else {
            return urlDb.substring(posicaoTerceiraBarra + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: extrairNomeBanco (Desafio Final) ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Padrão normal com querystring (?)
        String r1 = extrairNomeBanco("jdbc:mysql://127.0.0.1:3306/meu_banco?useSSL=false&timeout=5000");
        System.out.printf("Teste 1 | Esperado: %-12s | Obtido: %-12s | %s%n", "meu_banco", r1, "meu_banco".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Sem portas explícita ou parâmetros (vai até o fim)
        String r2 = extrairNomeBanco("jdbc:postgresql://db.awshost.com/clientes_db");
        System.out.printf("Teste 2 | Esperado: %-12s | Obtido: %-12s | %s%n", "clientes_db", r2, "clientes_db".equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - URL vazia/sem db especificado após a barra
        String r3 = extrairNomeBanco("jdbc:oracle://localhost:5432/");
        System.out.printf("Teste 3 | Esperado: %-12s | Obtido: %-12s | %s%n", "", r3, "".equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - URL malformada sem a barra do banco
        String r4 = extrairNomeBanco("jdbc:h2:mem");
        System.out.printf("Teste 4 | Esperado: %-12s | Obtido: %-12s | %s%n", "", r4, "".equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 5 - Não é uma conexão jdbc
        String r5 = extrairNomeBanco("https://site.com/db_nome");
        System.out.printf("Teste 5 | Esperado: %-12s | Obtido: %-12s | %s%n", "", r5, "".equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 6 - Nulo
        String r6 = extrairNomeBanco(null);
        System.out.printf("Teste 6 | Esperado: %-12s | Obtido: %-12s | %s%n", "", r6, "".equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
