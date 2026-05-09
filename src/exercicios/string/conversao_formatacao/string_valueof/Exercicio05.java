package exercicios.string.conversao_formatacao.string_valueof;

/**
 * Exercicio 05 - Desafio Final: Linha de auditoria com String.valueOf()
 *
 * Enunciado:
 * Um sistema precisa gerar uma linha simples de auditoria combinando valores
 * de varios tipos em uma unica String.
 *
 * O formato final deve ser:
 * "id=ID; ativo=ATIVO; total=TOTAL; observacao=OBSERVACAO"
 *
 * Exemplos:
 * id = 10, ativo = true, total = 99.5, observacao = "Pedido aprovado"
 * retorno = "id=10; ativo=true; total=99.5; observacao=Pedido aprovado"
 *
 * Regras:
 * 1. Converta id, ativo, total e observacao usando `String.valueOf()`.
 * 2. Se observacao for null, `String.valueOf(observacao)` deve gerar "null".
 * 3. Nao limpe espacos da observacao; preserve exatamente como chegou.
 *
 * Restricoes:
 * - Use `String.valueOf()` para cada valor recebido.
 * - Nao use Integer.toString(), Boolean.toString(), Double.toString() ou toString() direto.
 * - Nao use String.format().
 */
public class Exercicio05 {

    public static String gerarLinhaAuditoria(int id, boolean ativo, double total, String observacao) {

        return "id=" + String.valueOf(id) + "; " +
                "ativo=" + String.valueOf(ativo) + "; " +
                "total=" + String.valueOf(total) + "; " +
                "observacao=" + String.valueOf(observacao);
    }

    private static void imprimirTeste(int numero, String esperado, String obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == null ? obtido == null : esperado.equals(obtido);

        System.out.printf(
                "Teste %d | Esperado: %-65s | Obtido: %-65s | %s%n",
                numero,
                String.valueOf(esperado),
                String.valueOf(obtido),
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 05: gerarLinhaAuditoria ---");

        imprimirTeste(1,
                "id=10; ativo=true; total=99.5; observacao=Pedido aprovado",
                gerarLinhaAuditoria(10, true, 99.5, "Pedido aprovado"));

        imprimirTeste(2,
                "id=0; ativo=false; total=0.0; observacao=null",
                gerarLinhaAuditoria(0, false, 0.0, null));

        imprimirTeste(3,
                "id=-7; ativo=true; total=-15.75; observacao=Estorno manual",
                gerarLinhaAuditoria(-7, true, -15.75, "Estorno manual"));

        imprimirTeste(4,
                "id=42; ativo=false; total=1000.0; observacao=  manter espacos  ",
                gerarLinhaAuditoria(42, false, 1000.0, "  manter espacos  "));

        imprimirTeste(5,
                "id=2147483647; ativo=true; total=1.5; observacao=limite",
                gerarLinhaAuditoria(Integer.MAX_VALUE, true, 1.5, "limite"));
    }
}
