package TD6;

import java.util.Objects;

/**
 * Created by flthiebl on 28/11/2016.
 */
public class ProdCons {
    private Object buffer[];
    private int sizeMax;
    private int lire, ecrire;
    private int nbElmt;

    public ProdCons(Object[] buffer, int sizeMax, int lire, int ecrire, int nbElmt) {
        this.buffer = buffer;
        this.sizeMax = sizeMax;
        this.lire = lire;
        this.ecrire = ecrire;
        this.nbElmt = nbElmt;
    }

    synchronized void put(Object m){
        while (this.nbElmt == this.sizeMax) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.buffer[this.ecrire++] = m;
        notify();
        this.ecrire %= this.sizeMax;
        nbElmt++;
    }

    synchronized Object get(){
        while (this.nbElmt == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object m = this.buffer[this.lire++];
        this.lire %= this.sizeMax;
        notify();
        nbElmt--;
        return m;
    }
}
