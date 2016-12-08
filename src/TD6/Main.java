package TD6;

/**
 * Created by flthiebl on 28/11/2016.
 */
public class Main {
    static int N = 10;
    static String mess = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Flag theStop;

    /*public static void main(String[] args) {
        Semaphore sem = new Semaphore();
        Semaphore sG= null;
        Semaphore sD= null;

        theStop = new Flag();

        for (int i = 0; i < N; i++){
            sD = new Semaphore(0);
            UneTache tache = new UneTache();
            if (i == 0){
                tache = new UneTache(mess.charAt(i), sem, sD, theStop);
            } else if (i == N - 1) {
                tache = new UneTache(mess.charAt(i), sG, sem, theStop);
            } else {
                tache = new UneTache(mess.charAt(i), sG, sD, theStop);
            }
            tache.start();
            sG = sD;
        }
        sem.V();

        try {
            Thread.sleep(400);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("FIN");
        theStop.leve();
    }*/
}
