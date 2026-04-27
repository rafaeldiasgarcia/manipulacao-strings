package exercicios.startswith_endswith_contains;

/**
 * Exercicio 01 — startsWith(), endsWith(), contains()
 *
 * Enunciado:
 * Implemente `urlSegura` que recebe uma URL e retorna true
 * se ela começar com "https://".
 *
 * Restrição: use apenas startsWith(). Sem contains(), sem loops.
 */
public class Exercicio01 {

    public static boolean urlSegura(String url) {
        // TODO: implemente aqui
        return false;
    }

    public static void main(String[] args) {

        boolean r1 = urlSegura("https://api.empresa.com");
        boolean r2 = urlSegura("http://api.empresa.com");
        boolean r3 = urlSegura("https://");
        boolean r4 = urlSegura("ftp://arquivos.empresa.com");
        boolean r5 = urlSegura("HTTPS://api.empresa.com");

        // Teste 1 — https válido → true
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 — http sem s → false
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r2, !r2 ? "PASSOU" : "FALHOU");

        // Teste 3 — só o prefixo, sem domínio → ainda true (começa com https://)
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r3,  r3 ? "PASSOU" : "FALHOU");

        // Teste 4 — ftp → false
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 — HTTPS maiúsculo → false (case-sensitive!)
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5 ? "PASSOU" : "FALHOU");
    }
}
