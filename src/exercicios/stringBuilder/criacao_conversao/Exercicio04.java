package exercicios.stringBuilder.criacao_conversao;

/**
 * Exercicio 04 - Tamanho do texto inicial
 *
 * Enunciado:
 * Um sistema precisa descobrir quantos caracteres existem em um texto depois
 * de coloca-lo dentro de um StringBuilder.
 *
 * Implemente o metodo `obterTamanhoDoTextoInicial` criando um StringBuilder a
 * partir do texto recebido e retornando o tamanho do conteudo.
 *
 * Regras:
 * 1. Se texto for "Java", o retorno deve ser 4.
 * 2. Se texto for "", o retorno deve ser 0.
 * 3. Espacos contam como caracteres.
 * 4. Se texto for null, retorne -1.
 *
 * Restricoes:
 * - Use `new StringBuilder(texto)` quando texto nao for null.
 * - Use `length()` para obter o tamanho do conteudo.
 * - Nao use texto.length().
 * - Nao use toString() neste exercicio.
 */
public class Exercicio04 {

    public static int obterTamanhoDoTextoInicial(String texto) {

        if (texto == null) {
            return -1;
        }

        StringBuilder builder = new StringBuilder(texto);

        return builder.length();
    }

    private static void imprimirTeste(int numero, int esperado, int obtido) {
        String verde = "\u001B[32m";
        String vermelho = "\u001B[31m";
        String reset = "\u001B[0m";

        boolean passou = esperado == obtido;

        System.out.printf(
                "Teste %d | Esperado: %-10d | Obtido: %-10d | %s%n",
                numero,
                esperado,
                obtido,
                passou ? verde + "PASSOU" + reset : vermelho + "FALHOU" + reset
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Testes Exercicio 04: obterTamanhoDoTextoInicial ---");

        imprimirTeste(1, 4, obterTamanhoDoTextoInicial("Java"));
        imprimirTeste(2, 0, obterTamanhoDoTextoInicial(""));
        imprimirTeste(3, 5, obterTamanhoDoTextoInicial("A B C"));
        imprimirTeste(4, 13, obterTamanhoDoTextoInicial("StringBuilder"));
        imprimirTeste(5, -1, obterTamanhoDoTextoInicial(null));
    }
}
