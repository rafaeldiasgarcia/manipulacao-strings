package exercicios.comparacao.equals_equalsignorecase;

/**
 * Exercicio 04 - Múltiplas comparações seguras
 *
 * Enunciado:
 * Um sistema de questionário aceita apenas três respostas válidas: "SIM", "NAO" ou "TALVEZ".
 * A entrada do usuário deve ser flexível, aceitando qualquer variação de maiúsculas/minúsculas
 * (ex: "sim", "Sim", "SIM", "naO", etc).
 * 
 * Implemente a função `validarResposta` que recebe a resposta do usuário e retorna `true` 
 * apenas se for uma das três opções permitidas.
 * 
 * Restricao: Trate valores nulos! O usuário pode não ter respondido (null).
 */
public class Exercicio04 {

    public static boolean validarResposta(String resposta) {
        

        return "SIM".equalsIgnoreCase(resposta)
            || "NAO".equalsIgnoreCase(resposta)
            || "TALVEZ".equalsIgnoreCase(resposta);
    }

    public static void main(String[] args) {

        // Teste 1 - Valido (SIM minusculo) -> true
        boolean r1 = validarResposta("Sim");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - Valido (NAO misturado) -> true
        boolean r2 = validarResposta("NaO");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r2, r2 == true ? "PASSOU" : "FALHOU");

        // Teste 3 - Valido (TALVEZ maiusculo) -> true
        boolean r3 = validarResposta("TALVEZ");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r3, r3 == true ? "PASSOU" : "FALHOU");

        // Teste 4 - Invalido (qualquer outra coisa) -> false
        boolean r4 = validarResposta("COM CERTEZA");
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r4, r4 == false ? "PASSOU" : "FALHOU");

        // Teste 5 - Invalido (null) -> false
        boolean r5 = validarResposta(null);
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r5, r5 == false ? "PASSOU" : "FALHOU");
    }
}
