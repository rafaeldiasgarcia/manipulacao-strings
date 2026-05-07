package exercicios.modificacao_limpeza.tolowercase_touppercase;

/**
 * Exercicio 02 - Padronizacao de codigos com toUpperCase()
 *
 * Enunciado:
 * Em sistemas reais, codigos de produto, cupons e siglas costumam ser exibidos
 * e armazenados em letras maiusculas para manter um padrao visual.
 *
 * Implemente o metodo `padronizarCodigo` que recebe um codigo e retorna esse
 * texto em letras maiusculas usando `toUpperCase()`.
 *
 * Restricoes:
 * - Se o codigo for null, retorne null.
 * - Nao remova espacos.
 * - Nao altere numeros, hifens ou underscores manualmente.
 * - Nao use replace, replaceAll, equalsIgnoreCase ou regex.
 */
public class Exercicio02 {

    public static String padronizarCodigo(String codigo) {

        if (codigo == null) return null;

        return codigo.toUpperCase();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-25s | Obtido: %-25s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: padronizarCodigo ---");

        imprimirTeste(1, "ABC123", padronizarCodigo("abc123"));
        imprimirTeste(2, "PROMO-2026", padronizarCodigo("promo-2026"));
        imprimirTeste(3, "USER_ADMIN", padronizarCodigo("user_admin"));
        imprimirTeste(4, "JAVA", padronizarCodigo("JAVA"));
        imprimirTeste(5, "", padronizarCodigo(""));
        imprimirTeste(6, null, padronizarCodigo(null));
        imprimirTeste(7, " CUPOM-10 ", padronizarCodigo(" cupom-10 "));
    }
}
