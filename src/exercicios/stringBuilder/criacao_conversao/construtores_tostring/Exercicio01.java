package exercicios.stringBuilder.criacao_conversao.construtores_tostring;

/**
 * Exercicio 01 - Criando a partir de uma String
 *
 * Enunciado:
 * Um sistema recebeu um texto pronto, mas precisa coloca-lo dentro de um
 * StringBuilder para seguir o padrao de montagem de textos que sera usado
 * nos proximos exercicios.
 *
 * Implemente o metodo `copiarTexto` criando um StringBuilder a partir do texto
 * recebido e retornando o conteudo final como String.
 *
 * Regras:
 * 1. Se texto for "Java", o retorno deve ser "Java".
 * 2. Se texto for "", o retorno deve ser "".
 * 3. Se texto for null, o retorno deve ser null.
 *
 * Restricoes:
 * - Use `new StringBuilder(texto)` quando texto nao for null.
 * - Use `toString()` para converter o builder de volta para String.
 * - Nao use concatenacao.
 * - Nao use String.valueOf().
 */
public class Exercicio01 {

    public static String copiarTexto(String texto) {

        if (texto == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(texto);

        return builder.toString();
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
        System.out.println("--- Testes Exercicio 01: copiarTexto ---");

        imprimirTeste(1, "Java", copiarTexto("Java"));
        imprimirTeste(2, "", copiarTexto(""));
        imprimirTeste(3, "StringBuilder", copiarTexto("StringBuilder"));
        imprimirTeste(4, "A B C", copiarTexto("A B C"));
        imprimirTeste(5, null, copiarTexto(null));
    }
}
