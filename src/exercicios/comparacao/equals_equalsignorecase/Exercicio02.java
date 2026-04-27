package exercicios.comparacao.equals_equalsignorecase;

/**
 * Exercicio 02 - equalsIgnoreCase()
 *
 * Enunciado:
 * O sistema da loja possui um cupom de desconto chamado "DESCONTO10".
 * O usuário pode digitar o cupom em letras maiúsculas, minúsculas ou misturadas (ex: "Desconto10", "desconto10").
 * Implemente o método `validarCupom` que recebe o cupom digitado e verifica se ele é válido,
 * ignorando a diferença entre maiúsculas e minúsculas.
 *
 * Restricao: O cupom validado deve ser sempre contra a string "DESCONTO10".
 */
public class Exercicio02 {

    public static boolean validarCupom(String cupomDigitado) {

        return "DESCONTO10".equalsIgnoreCase(cupomDigitado);
    }

    public static void main(String[] args) {

        // Teste 1 - cupom identico -> true
        boolean r1 = validarCupom("DESCONTO10");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - cupom tudo minusculo -> true
        boolean r2 = validarCupom("desconto10");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r2, r2 == true ? "PASSOU" : "FALHOU");

        // Teste 3 - cupom misturado -> true
        boolean r3 = validarCupom("Desconto10");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r3, r3 == true ? "PASSOU" : "FALHOU");

        // Teste 4 - cupom incorreto -> false
        boolean r4 = validarCupom("PROMO10");
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r4, r4 == false ? "PASSOU" : "FALHOU");

        // Teste 5 - espaco no final (nao deve validar pois conteudo mudou) -> false
        boolean r5 = validarCupom("DESCONTO10 ");
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r5, r5 == false ? "PASSOU" : "FALHOU");
    }
}
