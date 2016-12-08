package TD5;

import java.util.concurrent.Semaphore;

/**
 * Created by flthiebl on 10/11/2016.
 */
public class Temoin extends Thread {
    private static final int n = 10;
    private static Semaphore[] sem;
    private Thread[] threads;

    public Temoin(String name) {
        super(name);

    }

    public void run(){

    }

    public static void main(String[] args) {
        for(int i = 0; i < n; i++){
            sem[i] = new Semaphore(1);
        }

        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};


    }
}
