package exercicios.fatiamento_busca.substring_split;

/**
 * Exercicio 04d - substring() + split() avançados num caso de uso real
 *
 * Enunciado:
 * Vamos construir uma mini função de roteador de requisições.
 * Muitas vezes recebemos uma string formatada como uma "Requisição HTTP fake":
 *
 * Ex: "GET /usuarios/5 HTTP/1.1" ou "POST /produtos HTTP/1.1"
 *
 * Precisamos extrair exatamente **O CAMINHO DA ROTA** (no caso, a parte do meio:
 * "/usuarios/5" e "/produtos").
 *
 * Implemente `extrairCaminhoRota` e use SEU ARSENAL de substring, split ou busca
 * (indexOf, lastIndexOf) para retornar a parte requerida.
 * A forma é com você, desde que retorne o caminho correto isolado dos espaços
 * e dos métodos HTTP das pontas!
 *
 * Restrições e Dicas:
 * - Toda rota vem garantida no formato "MÉTODO (ESPACE) /caminho (ESPACE) HTTP/1.1".
 * - O caminho começa garantidamente no PRIMEIRO espaço, e termina garantidamente
 *   no ÚLTIMO espaço antes do "HTTP" (dica: substring com posições extraídas,
 *   OU split dividindo por espaços e pegando a parte desejada!).
 * - Se for nulo ou vazio, retorne string vazia.
 */
public class Exercicio04d {

    public static String extrairCaminhoRota(String rawRequestLine) {

        if (rawRequestLine == null || rawRequestLine.isEmpty()) return "";

        int primeiroEspaco = rawRequestLine.indexOf(' ');
        int ultimoEspaco = rawRequestLine.lastIndexOf(' ');

        if (primeiroEspaco == -1 || primeiroEspaco == ultimoEspaco) return "";

        return rawRequestLine.substring(primeiroEspaco + 1, ultimoEspaco);
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04d: extrairCaminhoRota ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        String r1 = extrairCaminhoRota("GET /usuarios/5 HTTP/1.1");
        System.out.printf("Teste 1 | Esperado: %-15s | Obtido: %-15s | %s%n", "/usuarios/5", r1, "/usuarios/5".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r2 = extrairCaminhoRota("POST /api/v1/pagamentos HTTP/2.0");
        System.out.printf("Teste 2 | Esperado: %-15s | Obtido: %-15s | %s%n", "/api/v1/pagamentos", r2, "/api/v1/pagamentos".equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r3 = extrairCaminhoRota("DELETE / HTTP/1.1");
        System.out.printf("Teste 3 | Esperado: %-15s | Obtido: %-15s | %s%n", "/", r3, "/".equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r4 = extrairCaminhoRota("");
        System.out.printf("Teste 4 | Esperado: %-15s | Obtido: %-15s | %s%n", "", r4, "".equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        String r5 = extrairCaminhoRota(null);
        System.out.printf("Teste 5 | Esperado: %-15s | Obtido: %-15s | %s%n", "", r5, "".equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}
