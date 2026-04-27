package exercicios.inspecao_validacao.isempty_isblank;

/**
 * Exercicio 01 - isEmpty() e isBlank()
 *
 * Enunciado:
 * Implemente `campoPreenchido` que recebe uma String e retorna true
 * se o campo tiver conteudo real (nao nulo, nao vazio, nao so espacos).
 */
public class Exercicio01 {

    public static boolean campoPreenchido(String valor) {

        if (valor == null) return false;

        return !valor.isBlank();
    }

    public static void main(String[] args) {

        // Teste 1 - texto normal -> preenchido
        boolean r1 = campoPreenchido("Rafael");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 - string vazia -> nao preenchido
        boolean r2 = campoPreenchido("");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 - so espacos -> nao preenchido
        boolean r3 = campoPreenchido("   ");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r3, !r3 ? "PASSOU" : "FALHOU");

        // Teste 4 - null -> nao preenchido
        boolean r4 = campoPreenchido(null);
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 - espacos nas bordas mas tem conteudo -> preenchido
        boolean r5 = campoPreenchido("  Java  ");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r5,  r5 ? "PASSOU" : "FALHOU");
    }
}
