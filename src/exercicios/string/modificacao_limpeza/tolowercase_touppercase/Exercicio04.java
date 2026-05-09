package exercicios.string.modificacao_limpeza.tolowercase_touppercase;

/**
 * Exercicio 04 - Formatacao de etiqueta com toUpperCase()
 *
 * Enunciado:
 * Uma tela administrativa precisa exibir etiquetas de prioridade no formato:
 * "[PRIORIDADE] mensagem"
 *
 * A prioridade deve aparecer sempre em letras maiusculas, mas a mensagem deve
 * ser mantida exatamente como chegou, sem conversao de maiusculas/minusculas.
 *
 * Implemente o metodo `formatarEtiqueta` que recebe uma prioridade e uma mensagem
 * e retorna a etiqueta formatada.
 *
 * Regras:
 * 1. Se a prioridade for null, vazia ou apenas espacos, use "GERAL".
 * 2. Se a mensagem for null, use uma string vazia "".
 * 3. A prioridade deve ser limpa nas bordas com `strip()` e convertida com `toUpperCase()`.
 * 4. A mensagem deve ser limpa apenas nas bordas com `strip()`, sem mudar sua caixa.
 *
 * Restricoes:
 * - Use `toUpperCase()` apenas na prioridade.
 * - Nao use replace, replaceAll, equalsIgnoreCase ou regex.
 */
public class Exercicio04 {

    public static String formatarEtiqueta(String prioridade, String mensagem) {

        if (prioridade == null || prioridade.isBlank()) {
            prioridade = "GERAL";
        }

        mensagem = mensagem == null ? "" : mensagem;

        return "[" + prioridade.strip().toUpperCase() + "] " + mensagem.strip();
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-35s | Obtido: %-35s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04: formatarEtiqueta ---");

        imprimirTeste(1, "[ALTA] Corrigir bug critico", formatarEtiqueta("alta", "Corrigir bug critico"));
        imprimirTeste(2, "[MEDIA] Revisar cadastro", formatarEtiqueta("  MeDiA  ", "  Revisar cadastro  "));
        imprimirTeste(3, "[GERAL] Sem prioridade definida", formatarEtiqueta("", "Sem prioridade definida"));
        imprimirTeste(4, "[GERAL] Mensagem sem grupo", formatarEtiqueta("   ", "Mensagem sem grupo"));
        imprimirTeste(5, "[GERAL] Sistema iniciado", formatarEtiqueta(null, "Sistema iniciado"));
        imprimirTeste(6, "[BAIXA] ", formatarEtiqueta("baixa", null));
        imprimirTeste(7, "[URGENTE] API respondeu com Timeout", formatarEtiqueta("\turgente\n", "\nAPI respondeu com Timeout\t"));
    }
}
