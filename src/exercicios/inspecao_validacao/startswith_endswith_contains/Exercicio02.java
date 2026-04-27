package exercicios.inspecao_validacao.startswith_endswith_contains;

/**
 * Exercicio 02 - endsWith()
 *
 * Enunciado:
 * Implemente `arquivoPermitido` que recebe o nome de um arquivo e retorna
 * true se ele terminar com ".jpg", ".png" ou ".gif" (case-sensitive).
 */
public class Exercicio02 {

    public static boolean arquivoPermitido(String nomeArquivo) {

        return nomeArquivo.endsWith(".jpg")
            || nomeArquivo.endsWith(".png")
            || nomeArquivo.endsWith(".gif");
    }

    public static void main(String[] args) {

        // Teste 1 - .jpg -> permitido
        boolean r1 = arquivoPermitido("foto.jpg");
        System.out.printf("Teste 1 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r1,  r1 ? "PASSOU" : "FALHOU");

        // Teste 2 - .png -> permitido
        boolean r2 = arquivoPermitido("imagem.png");
        System.out.printf("Teste 2 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r2,  r2 ? "PASSOU" : "FALHOU");

        // Teste 3 - .gif -> permitido
        boolean r3 = arquivoPermitido("animacao.gif");
        System.out.printf("Teste 3 | Esperado: %-5s | Obtido: %-5s | %s%n", "true",  r3,  r3 ? "PASSOU" : "FALHOU");

        // Teste 4 - .pdf -> nao permitido
        boolean r4 = arquivoPermitido("documento.pdf");
        System.out.printf("Teste 4 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r4, !r4 ? "PASSOU" : "FALHOU");

        // Teste 5 - .JPG maiusculo -> nao permitido (case-sensitive)
        boolean r5 = arquivoPermitido("foto.JPG");
        System.out.printf("Teste 5 | Esperado: %-5s | Obtido: %-5s | %s%n", "false", r5, !r5 ? "PASSOU" : "FALHOU");
    }
}
