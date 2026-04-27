package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 04c - Encontrar substring entre delimitadores
 *
 * Implemente `extrairEntre` que recebe uma String e dois chars (abertura e fechamento),
 * e retorna o conteúdo entre a primeira ocorrência de cada um.
 *
 * Ex: extrairEntre("Ola [mundo] aqui", '[', ']') → "mundo"
 *
 * Se a String for nula, os delimitadores não existirem, ou abertura vier depois do fechamento,
 * retorne null.
 *
 * Restrição: use indexOf() e substring().
 */
public class Exercicio04c {

    public static String extrairEntre(String texto, char abertura, char fechamento) {

        if (texto == null) return null;

        int posicaoAbertura = texto.indexOf(abertura);
        if (posicaoAbertura == -1) return null;

        int posicaoFechamento = texto.indexOf(fechamento, posicaoAbertura + 1);
        if (posicaoFechamento == -1) return null;

        return texto.substring(posicaoAbertura + 1, posicaoFechamento);
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 04c: extrairEntre ---");

        // Teste 1 - conteúdo normal entre colchetes → "mundo"
        String r1 = extrairEntre("Ola [mundo] aqui", '[', ']');
        System.out.printf("Teste 1 | Esperado: %-10s | Obtido: %-10s | %s%n", "mundo", r1, "mundo".equals(r1) ? "PASSOU" : "FALHOU");

        // Teste 2 - delimitadores diferentes (parênteses) → "tabela"
        String r2 = extrairEntre("SELECT * FROM (tabela)", '(', ')');
        System.out.printf("Teste 2 | Esperado: %-10s | Obtido: %-10s | %s%n", "tabela", r2, "tabela".equals(r2) ? "PASSOU" : "FALHOU");

        // Teste 3 - sem delimitadores → null
        String r3 = extrairEntre("sem delimitador", '[', ']');
        System.out.printf("Teste 3 | Esperado: %-10s | Obtido: %-10s | %s%n", "null", r3, r3 == null ? "PASSOU" : "FALHOU");

        // Teste 4 - nulo → null
        String r4 = extrairEntre(null, '[', ']');
        System.out.printf("Teste 4 | Esperado: %-10s | Obtido: %-10s | %s%n", "null", r4, r4 == null ? "PASSOU" : "FALHOU");

        // Teste 5 - delimitadores sem conteúdo entre eles → ""
        String r5 = extrairEntre("[]", '[', ']');
        System.out.printf("Teste 5 | Esperado: %-10s | Obtido: %-10s | %s%n", "\"\"", r5, "".equals(r5) ? "PASSOU" : "FALHOU");
    }
}
