package TD7;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by flthiebl on 01/12/2016.
 */
public class Eratosthene {
    private static final int THREAD_FIRST = 2;
    private static final int THREAD_LAST = 10;

    public static final int MAX = (int) Math.pow(THREAD_LAST, 2);
    private static boolean[] premiers = new boolean[MAX];

    public static void main(String[] args) {
        System.out.println("Crible d'Erastosthene multithread.");
        for (int i = THREAD_FIRST; i <= THREAD_LAST; i++){
            new Filtreur(premiers);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie){}
        for (int i = THREAD_FIRST; i < MAX; i++){
            if (!premiers[i]) {
                System.out.println(i);
            }
        }
    }
}
