package TD7;

/**
 * Created by flthiebl on 01/12/2016.
 */
public class Filtreur implements Runnable {
    private static int ident = 2;
    private int identPrive;
    private boolean[] premiers;

    public Filtreur(boolean[] premiers) {
        identPrive = ident++;
        this.premiers = premiers;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = (int)Math.pow(identPrive, 2); i < Eratosthene.MAX; i += identPrive) {
            if(!premiers[i]) {
                premiers[i] = i%identPrive == 0;
            }
        }
    }
}
