package exercicios.stringBuilder.criacao_conversao;

/**
 * Exercicio 03 - Criando com capacidade inicial
 *
 * Enunciado:
 * Um sistema vai montar textos de tamanhos diferentes e quer criar um
 * StringBuilder ja com uma capacidade inicial estimada.
 *
 * Implemente o metodo `obterCapacidadeInicial` criando um StringBuilder com a
 * capacidade recebida e retornando a capacidade real do builder.
 *
 * Regras:
 * 1. Se capacidade for 0, o retorno deve ser 0.
 * 2. Se capacidade for 10, o retorno deve ser 10.
 * 3. Se capacidade for 50, o retorno deve ser 50.
 * 4. Se capacidade for negativa, retorne -1.
 *
 * Restricoes:
 * - Use `new StringBuilder(capacidade)` quando capacidade nao for negativa.
 * - Use `capacity()` para obter a capacidade do builder.
 * - Nao use length() neste exercicio.
 */
public class Exercicio03 {

    public static int obterCapacidadeInicial(int capacidade) {

        if (capacidade < 0) {
            return -1;
        }

        StringBuilder builder = new StringBuilder(capacidade);

        return builder.capacity();
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
        System.out.println("--- Testes Exercicio 03: obterCapacidadeInicial ---");

        imprimirTeste(1, 0, obterCapacidadeInicial(0));
        imprimirTeste(2, 1, obterCapacidadeInicial(1));
        imprimirTeste(3, 10, obterCapacidadeInicial(10));
        imprimirTeste(4, 50, obterCapacidadeInicial(50));
        imprimirTeste(5, -1, obterCapacidadeInicial(-1));
    }
}
