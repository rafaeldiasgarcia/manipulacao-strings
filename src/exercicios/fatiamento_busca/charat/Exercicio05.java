package exercicios.fatiamento_busca.charat;

/**
 * Exercicio 05 (Desafio Final) - Validador de Máscara de CPF
 *
 * Enunciado:
 * Muitas vezes precisamos verificar se uma String está no formato correto antes de
 * tentar extrair dados dela.
 * 
 * Implemente a função `validarMascaraCPF` que recebe uma String e verifica se ela 
 * está no formato exato: XXX.XXX.XXX-XX (onde X pode ser qualquer coisa, mas as
 * pontuações devem estar nos lugares corretos).
 * 
 * Regras para ser válido:
 * 1. Tem que ter exatamente 14 caracteres de tamanho.
 * 2. O caractere no índice 3 deve ser um ponto ('.').
 * 3. O caractere no índice 7 deve ser um ponto ('.').
 * 4. O caractere no índice 11 deve ser um traço ('-').
 * 
 * Se bater com TODAS essas regras, retorne true. Caso contrário, false.
 * Trate nulos devolvendo false.
 */
public class Exercicio05 {

    public static boolean validarMascaraCPF(String cpf) {

        return cpf != null
            && !cpf.isBlank()
            && cpf.length() == 14
            && cpf.charAt(3) == '.'
            && cpf.charAt(7) == '.'
            && cpf.charAt(11) == '-';
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 05: validarMascaraCPF ---");

        // Teste 1 - Correto
        boolean r1 = validarMascaraCPF("123.456.789-00");
        System.out.printf("Teste 1 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r1, r1 == true ? "PASSOU" : "FALHOU");

        // Teste 2 - Falta o traco
        boolean r2 = validarMascaraCPF("123.456.789.00");
        System.out.printf("Teste 2 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r2, r2 == false ? "PASSOU" : "FALHOU");

        // Teste 3 - Tamanho errado
        boolean r3 = validarMascaraCPF("12.345.678-90");
        System.out.printf("Teste 3 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r3, r3 == false ? "PASSOU" : "FALHOU");

        // Teste 4 - Nulo
        boolean r4 = validarMascaraCPF(null);
        System.out.printf("Teste 4 | Esperado: %-5b | Obtido: %-5b | %s%n", false, r4, r4 == false ? "PASSOU" : "FALHOU");

        // Teste 5 - Letras no lugar de numeros mas com a mascara certa (isso o nosso validador basico vai aceitar, ta certo!)
        boolean r5 = validarMascaraCPF("ABC.DEF.GHI-JK");
        System.out.printf("Teste 5 | Esperado: %-5b | Obtido: %-5b | %s%n", true, r5, r5 == true ? "PASSOU" : "FALHOU");
    }
}
