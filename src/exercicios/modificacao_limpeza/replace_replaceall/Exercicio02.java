package exercicios.modificacao_limpeza.replace_replaceall;

/**
 * Exercicio 02 - replaceAll() (Regex) para extrair somente dígitos
 *
 * Enunciado:
 * O `replaceAll(regex, replacement)` aceita Expressões Regulares (Regex).
 * Um caso extremamente comum é remover tudo que NÃO é número.
 *
 * Implemente `extrairSomenteDigitos` que recebe um texto qualquer e devolve
 * apenas os dígitos concatenados.
 *
 * Dicas:
 * - Em regex, `\D` significa "não-dígito".
 * - Em Java, para passar o regex `\D` você escreve a String literal: "\\D".
 * - Para remover 1 ou mais não-dígitos de uma vez, use: `texto.replaceAll("\\D+", "")`.
 *
 * Restrições:
 * - Se `texto` for null, retorne "".
 * - Se `texto` for vazio ou isBlank(), retorne "".
 */
public class Exercicio02 {

    public static String extrairSomenteDigitos(String texto) {

        if (texto == null || texto.isBlank()) return "";

        return texto.replaceAll("\\D+", "");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 02: extrairSomenteDigitos ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - CPF com máscara
        String r1 = extrairSomenteDigitos("CPF: 123.456.789-00");
        String e1 = "12345678900";
        System.out.printf("Teste 1 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e1, r1, e1.equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Telefone com caracteres variados
        String r2 = extrairSomenteDigitos("+55 (11) 9 8765-4321");
        String e2 = "5511987654321";
        System.out.printf("Teste 2 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e2, r2, e2.equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Já é só dígito
        String r3 = extrairSomenteDigitos("000123");
        String e3 = "000123";
        System.out.printf("Teste 3 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e3, r3, e3.equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 4 - Sem nenhum dígito
        String r4 = extrairSomenteDigitos("abc-XYZ");
        String e4 = "";
        System.out.printf("Teste 4 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e4, r4, e4.equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 5 - Misturado com underscores e símbolos
        String r5 = extrairSomenteDigitos("a1_b2-c3");
        String e5 = "123";
        System.out.printf("Teste 5 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e5, r5, e5.equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 6 - String vazia
        String r6 = extrairSomenteDigitos("");
        String e6 = "";
        System.out.printf("Teste 6 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e6, r6, e6.equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 7 - String só com espaços
        String r7 = extrairSomenteDigitos("   \t\n");
        String e7 = "";
        System.out.printf("Teste 7 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e7, r7, e7.equals(r7) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 8 - Null
        String r8 = extrairSomenteDigitos(null);
        String e8 = "";
        System.out.printf("Teste 8 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e8, String.valueOf(r8), e8.equals(r8) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

