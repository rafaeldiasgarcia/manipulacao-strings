package exercicios.modificacao_limpeza.replace_replaceall;

/**
 * Exercicio 04 - replaceAll() para normalizar espaços (\s+)
 *
 * Enunciado:
 * Em inputs de usuário (formulários, colagens, OCR, chat), é comum receber texto com
 * espaços irregulares: múltiplos espaços, tabs (\t) e quebras de linha (\n).
 *
 * Queremos normalizar para um formato amigável:
 * - Sequências de espaços em branco viram UM único espaço (" ")
 * - Não pode sobrar espaço no começo nem no fim
 *
 * Implemente `normalizarEspacos` usando `replaceAll`.
 *
 * Dicas:
 * - Regex `\s+` casa "1 ou mais" whitespaces (espaço, tab, \n, etc)
 * - Para remover espaços só das bordas via regex: `^\s+|\s+$`
 *
 * Restrições:
 * - Se `texto` for null, retorne "".
 * - Se `texto` for vazio ou isBlank(), retorne "".
 */
public class Exercicio04 {

    public static String normalizarEspacos(String texto) {

        if (texto == null || texto.isBlank()) return "";

        // 1) Remove bordas (não pode sobrar espaço no começo/fim)
        // 2) Normaliza o "miolo": qualquer sequência de whitespaces vira 1 espaço
        return texto
                .replaceAll("^\\p{javaWhitespace}+|\\p{javaWhitespace}+$", "")
                .replaceAll("\\p{javaWhitespace}+", " ");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04: normalizarEspacos ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Múltiplos espaços + tabs + quebra de linha
        String r1 = normalizarEspacos("   Joao   da\tSilva\n");
        String e1 = "Joao da Silva";
        System.out.printf("Teste 1 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e1, r1, e1.equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Já normalizado
        String r2 = normalizarEspacos("Backend Java");
        String e2 = "Backend Java";
        System.out.printf("Teste 2 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e2, r2, e2.equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Só 1 palavra
        String r3 = normalizarEspacos("API");
        String e3 = "API";
        System.out.printf("Teste 3 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e3, r3, e3.equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 4 - Começo e fim com espaços
        String r4 = normalizarEspacos("   a  b   ");
        String e4 = "a b";
        System.out.printf("Teste 4 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e4, r4, e4.equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 5 - Múltiplas quebras de linha
        String r5 = normalizarEspacos("a\n\n\n\tb");
        String e5 = "a b";
        System.out.printf("Teste 5 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e5, r5, e5.equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 6 - Unicode whitespace no meio (\u2003)
        String r6 = normalizarEspacos("a\u2003\u2003b");
        String e6 = "a b";
        System.out.printf("Teste 6 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e6, r6, e6.equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 7 - Vazio
        String r7 = normalizarEspacos("");
        String e7 = "";
        System.out.printf("Teste 7 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e7, r7, e7.equals(r7) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 8 - Só espaços
        String r8 = normalizarEspacos("   \t\n");
        String e8 = "";
        System.out.printf("Teste 8 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e8, r8, e8.equals(r8) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 9 - Null
        String r9 = normalizarEspacos(null);
        String e9 = "";
        System.out.printf("Teste 9 | Esperado: %-20s | Obtido: %-20s | %s%n",
                e9, String.valueOf(r9), e9.equals(r9) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

