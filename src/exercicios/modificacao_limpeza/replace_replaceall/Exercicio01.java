package exercicios.modificacao_limpeza.replace_replaceall;

/**
 * Exercicio 01 - replace() (substituição literal)
 *
 * Enunciado:
 * Em sistemas de cadastro é comum receber telefone com máscara (caracteres de formatação), por exemplo:
 * - "+55 (11) 9 8765-4321"
 * - "(11)98765-4321"
 * - "11 98765 4321"
 *
 * Para persistir no banco e facilitar buscas, queremos salvar um formato "normalizado":
 * somente os dígitos, sem espaços, parênteses, sinal de + ou hífens.
 *
 * Implemente `normalizarTelefone` usando APENAS substituições literais com `replace`.
 *
 * Restrições:
 * - Se `telefone` for null, retorne null.
 * - Se `telefone` for vazio (""), retorne "".
 * - Para este exercício, remova apenas estes caracteres: "(", ")", "-", " ", "+".
 */
public class Exercicio01 {

    public static String normalizarTelefone(String telefone) {

        if (telefone == null) return null;
        if (telefone.isEmpty()) return "";

        return telefone
                .replace("(", "")
                .replace(")", "")
                .replace("-", "")
                .replace(" ", "")
                .replace("+", "");
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 01: normalizarTelefone ---");

        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        // Teste 1 - Com +, parênteses, espaços e hífen
        String r1 = normalizarTelefone("+55 (11) 9 8765-4321");
        String e1 = "5511987654321";
        System.out.printf("Teste 1 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e1, r1, e1.equals(r1) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 2 - Sem + e com máscara
        String r2 = normalizarTelefone("(11)98765-4321");
        String e2 = "11987654321";
        System.out.printf("Teste 2 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e2, r2, e2.equals(r2) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 3 - Apenas espaços como separadores
        String r3 = normalizarTelefone("11 98765 4321");
        String e3 = "11987654321";
        System.out.printf("Teste 3 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e3, r3, e3.equals(r3) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Teste 4 - Já normalizado (deve voltar igual)
        String r4 = normalizarTelefone("5511987654321");
        String e4 = "5511987654321";
        System.out.printf("Teste 4 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e4, r4, e4.equals(r4) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 5 - Vazio
        String r5 = normalizarTelefone("");
        String e5 = "";
        System.out.printf("Teste 5 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e5, r5, e5.equals(r5) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 6 - Null
        String r6 = normalizarTelefone(null);
        System.out.printf("Teste 6 | Esperado: %-15s | Obtido: %-15s | %s%n",
                "null", String.valueOf(r6), r6 == null ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);

        // Edge case 7 - Só caracteres removíveis
        String r7 = normalizarTelefone(" + ( ) -   ");
        String e7 = "";
        System.out.printf("Teste 7 | Esperado: %-15s | Obtido: %-15s | %s%n",
                e7, r7, e7.equals(r7) ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset);
    }
}

