package exercicios.string.modificacao_limpeza.tolowercase_touppercase;

/**
 * Exercicio 05 - Desafio Final: Normalizacao de usuario
 *
 * Enunciado:
 * Um sistema precisa gerar uma identificacao padronizada para usuarios a partir
 * de dois campos vindos de formulario:
 *
 * - perfil: tipo do usuario, como "admin", "cliente", "suporte"
 * - email: e-mail usado no login
 *
 * A identificacao final deve seguir o formato:
 * "PERFIL:email"
 *
 * Exemplos:
 * perfil = " admin ", email = " RAFAEL@EMAIL.COM "
 * retorno = "ADMIN:rafael@email.com"
 *
 * perfil = "Suporte", email = "HELP@EMPRESA.COM"
 * retorno = "SUPORTE:help@empresa.com"
 *
 * Regras:
 * 1. Se o perfil for null, vazio ou apenas espacos, use "USUARIO".
 * 2. Se o email for null, vazio ou apenas espacos, retorne "EMAIL_INVALIDO".
 * 3. O perfil deve ser limpo nas bordas com `strip()` e convertido com `toUpperCase()`.
 * 4. O email deve ser limpo nas bordas com `strip()` e convertido com `toLowerCase()`.
 * 5. Retorne o resultado concatenando perfil e email com dois-pontos: "PERFIL:email".
 *
 * Restricoes:
 * - Use `toUpperCase()` para o perfil.
 * - Use `toLowerCase()` para o email.
 * - Nao use replace, replaceAll, equalsIgnoreCase ou regex.
 */
public class Exercicio05 {

    public static String gerarIdentificacao(String perfil, String email) {

        if (perfil == null || perfil.isBlank()) {
            perfil = "USUARIO";
        }
        if (email == null || email.isBlank()) {
            return "EMAIL_INVALIDO";
        }

        String perfilNormalizado = perfil.strip().toUpperCase();
        String emailNormalizado = email.strip().toLowerCase();

        return perfilNormalizado + ":" + emailNormalizado;
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
        System.out.println("--- Testes Exercicio 05: gerarIdentificacao ---");

        imprimirTeste(1, "ADMIN:rafael@email.com", gerarIdentificacao(" admin ", " RAFAEL@EMAIL.COM "));
        imprimirTeste(2, "SUPORTE:help@empresa.com", gerarIdentificacao("Suporte", "HELP@EMPRESA.COM"));
        imprimirTeste(3, "USUARIO:cliente@site.com", gerarIdentificacao("", "Cliente@Site.COM"));
        imprimirTeste(4, "USUARIO:teste@site.com", gerarIdentificacao("   ", "  TESTE@SITE.COM  "));
        imprimirTeste(5, "USUARIO:anonimo@email.com", gerarIdentificacao(null, "Anonimo@Email.COM"));
        imprimirTeste(6, "EMAIL_INVALIDO", gerarIdentificacao("admin", ""));
        imprimirTeste(7, "EMAIL_INVALIDO", gerarIdentificacao("admin", "    "));
        imprimirTeste(8, "EMAIL_INVALIDO", gerarIdentificacao("admin", null));
        imprimirTeste(9, "CLIENTE:nome.sobrenome@email.com", gerarIdentificacao("\tcliente\n", "\nNome.Sobrenome@EMAIL.COM\t"));
    }
}
