package util;

public class Cronometro {

    private static long inicio;
    private static boolean aquecido = false;

    public static void iniciar() {
        if (!aquecido) {
            long dummy = 0;
            for (int i = 0; i < 50_000; i++) dummy += i;
            if (dummy < 0) System.out.println(dummy); // evita otimizacao pelo compilador
            aquecido = true;
        }
        inicio = System.nanoTime();
    }

    public static void parar() {
        double ms = (System.nanoTime() - inicio) / 1_000_000.0;
        System.out.printf("         Tempo: %.4f ms%n%n", ms);
    }
}
