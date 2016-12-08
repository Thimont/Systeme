package TD3;

/**
 * Created by flthiebl on 30/09/2016.
 */
public class SemBinaire {
    int Scpt = 1;

    public void E0(int val){Scpt=val;}
    public synchronized void V(){
        Scpt++;
        if (Scpt <= 0) notify();
    }
    public synchronized void P(){
        Scpt --;
        if (Scpt < 0) try { wait();} catch (Exception e) {	}
    }

}
