package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 02 - Extrair o domínio de um e-mail
 *
 * Dado um e-mail válido, retorne tudo que vem DEPOIS do '@'.
 * Ex: "usuario@gmail.com" → "gmail.com"
 *
 * Se a String for nula ou não contiver '@', retorne null.
 *
 * Restrições: use indexOf() e substring().
 */
public class Exercicio02 {

    public static String extrairDominio(String email) {

        if (email == null) return null;
        int posicao = email.indexOf('@');

        return posicao != -1 ? email.substring(posicao + 1) : null;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 02: extrairDominio ---");

        // Teste 1 - e-mail normal → "gmail.com"
        String r1 = extrairDominio("usuario@gmail.com");
        System.out.printf("Teste 1 | Esperado: %-15s | Obtido: %-15s | %s%n", "gmail.com", r1, "gmail.com".equals(r1) ? "PASSOU" : "FALHOU");

        // Teste 2 - domínio com subdomínio → "empresa.com.br"
        String r2 = extrairDominio("contato@empresa.com.br");
        System.out.printf("Teste 2 | Esperado: %-15s | Obtido: %-15s | %s%n", "empresa.com.br", r2, "empresa.com.br".equals(r2) ? "PASSOU" : "FALHOU");

        // Teste 3 - sem '@' → null
        String r3 = extrairDominio("emailinvalido.com");
        System.out.printf("Teste 3 | Esperado: %-15s | Obtido: %-15s | %s%n", "null", r3, r3 == null ? "PASSOU" : "FALHOU");

        // Teste 4 - nulo → null
        String r4 = extrairDominio(null);
        System.out.printf("Teste 4 | Esperado: %-15s | Obtido: %-15s | %s%n", "null", r4, r4 == null ? "PASSOU" : "FALHOU");

        // Teste 5 - só o '@', nada depois → ""
        String r5 = extrairDominio("@");
        System.out.printf("Teste 5 | Esperado: %-15s | Obtido: %-15s | %s%n", "\"\"", r5, "".equals(r5) ? "PASSOU" : "FALHOU");
    }
}
