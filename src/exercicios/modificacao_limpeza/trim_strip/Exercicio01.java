package exercicios.modificacao_limpeza.trim_strip;

/**
 * Exercicio 01 - Limpeza básica com strip() / trim()
 *
 * Enunciado:
 * Estamos construindo o backend de um formulário de cadastro de e-mail.
 * Usuários frequentemente copiam e colam o próprio e-mail e acabam enviando
 * espaços sobrando e até mesmo quebras de linha invisíveis (espaços no início e no fim).
 *
 * Implemente a função `limparEmailInput` que recebe a string de e-mail
 * vinda do frontend e retorna ela higienizada (sem os espaços das bordas).
 *
 * Restrições e Tratamentos:
 * - Se a entrada for nula, retorne null.
 * - Sinta-se livre para usar trim() ou strip(), mas o strip() é mais encorajado hoje em dia!
 */
public class Exercicio01 {

    public static String limparEmailInput(String emailRaw) {

        if (emailRaw == null) return null;

        return emailRaw.strip();
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 01: limparEmailInput ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        String r1 = limparEmailInput("  joao@email.com  ");
        System.out.printf("Teste 1 | Esperado: %-20s | Obtido: %-20s | %s%n", "joao@email.com", r1, "joao@email.com".equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // String sem espaços (deveria retornar idêntica)
        String r2 = limparEmailInput("maria@gmail.com");
        System.out.printf("Teste 2 | Esperado: %-20s | Obtido: %-20s | %s%n", "maria@gmail.com", r2, "maria@gmail.com".equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Apenas espaço de um lado
        String r3 = limparEmailInput("carlos@hotmail.com   ");
        System.out.printf("Teste 3 | Esperado: %-20s | Obtido: %-20s | %s%n", "carlos@hotmail.com", r3, "carlos@hotmail.com".equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Com tabs \t e quebra de linha \n
        String r4 = limparEmailInput("\t   contato@empresa.com.br \n");
        System.out.printf("Teste 4 | Esperado: %-20s | Obtido: %-20s | %s%n", "contato@empresa.com.br", r4, "contato@empresa.com.br".equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Nulo
        String r5 = limparEmailInput(null);
        System.out.printf("Teste 5 | Esperado: %-20s | Obtido: %-20s | %s%n", "null", String.valueOf(r5), r5 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Vazio ou só espaços
        String r6 = limparEmailInput("   ");
        System.out.printf("Teste 6 | Esperado: %-20s | Obtido: %-20s | %s%n", "", r6, "".equals(r6) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

