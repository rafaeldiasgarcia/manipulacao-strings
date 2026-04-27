package exercicios.inspecao_validacao.startswith_endswith_contains;


/**
 * Exercicio 01 - startsWith()
 *
 * Enunciado:
 * Implemente `urlSegura` que recebe uma URL e retorna true
 * se ela comecar com "https://".
 */
public class Exercicio01 {

    public static boolean urlSegura(String url) {

        return url.startsWith("https://");
    }

    public static void main(String[] args) {

        // Teste 1 - https valido -> true
        boolean r1 = urlSegura("https://api.empresa.com");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 - http sem s -> false
        boolean r2 = urlSegura("http://api.empresa.com");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 - so o prefixo, sem dominio -> true
        boolean r3 = urlSegura("https://");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r3,  r3 ? "PASSOU" : "FALHOU");

        // Teste 4 - ftp -> false
        boolean r4 = urlSegura("ftp://arquivos.empresa.com");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 - HTTPS maiusculo -> false (case-sensitive)
        boolean r5 = urlSegura("HTTPS://api.empresa.com");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5 ? "PASSOU" : "FALHOU");
    }
}
