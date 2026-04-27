package exercicios.fatiamento_busca.indexof;

/**
 * Exercicio 01 - indexOf() Básico
 *
 * Enunciado:
 * A forma mais clássica de usar o `indexOf` é simplesmente verificar se um caractere
 * existe na String sem precisar percorrer com um laço de repetição inteiro.
 * 
 * Implemente a função `temArroba` que recebe uma String representando um e-mail e 
 * retorna `true` se existir pelo menos um '@' (arroba) nela, e `false` caso contrário.
 * 
 * Dica: O indexOf retorna o índice onde achou, ou -1 se não achar!
 * 
 * Restricao: O sistema pode mandar um nulo. Se for nulo, retorne false.
 */
public class Exercicio01 {

    public static int posicaoArroba(String email) {
        
        return email != null ? email.indexOf('@') : -1;
    }

    public static void main(String[] args) {

        System.out.println("--- Testes Exercicio 01: posicaoArroba ---");

        // Teste 1 - '@' no índice 7
        int r1 = posicaoArroba("usuario@email.com");
        System.out.printf("Teste 1 | Esperado: %-3d | Obtido: %-3d | %s%n", 7, r1, r1 == 7 ? "PASSOU" : "FALHOU");

        // Teste 2 - '@' no início, índice 0
        int r2 = posicaoArroba("@dominio.com");
        System.out.printf("Teste 2 | Esperado: %-3d | Obtido: %-3d | %s%n", 0, r2, r2 == 0 ? "PASSOU" : "FALHOU");

        // Teste 3 - sem '@' → -1
        int r3 = posicaoArroba("emailinvalido.com");
        System.out.printf("Teste 3 | Esperado: %-3d | Obtido: %-3d | %s%n", -1, r3, r3 == -1 ? "PASSOU" : "FALHOU");

        // Teste 4 - nulo → -1
        int r4 = posicaoArroba(null);
        System.out.printf("Teste 4 | Esperado: %-3d | Obtido: %-3d | %s%n", -1, r4, r4 == -1 ? "PASSOU" : "FALHOU");

        // Teste 5 - string vazia → -1
        int r5 = posicaoArroba("");
        System.out.printf("Teste 5 | Esperado: %-3d | Obtido: %-3d | %s%n", -1, r5, r5 == -1 ? "PASSOU" : "FALHOU");
    }
}
