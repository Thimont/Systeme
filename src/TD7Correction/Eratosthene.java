package TD7Correction;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by flthiebl on 01/12/2016.
 */
public class Eratosthene{
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> buf;

        buf = new ArrayBlockingQueue<Integer>(1);
        UneTacheFiltre t = new UneTacheFiltre(buf, new Integer(2));
        t.start();

        for (int i = 3; i < 50; i += 2) {
            buf.put(new Integer(i));
            Thread.sleep(5);
        }
        buf.put(new Integer(0));
    }
}
