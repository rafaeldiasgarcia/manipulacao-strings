package util;

public class Cronometro {

    private static long inicio;

    public static void iniciar() {
        inicio = System.nanoTime();
    }

    public static void parar() {
        double ms = (System.nanoTime() - inicio) / 1_000_000.0;
        System.out.printf("         Tempo: %.4f ms%n%n", ms);
    }
}
