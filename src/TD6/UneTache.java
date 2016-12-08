package TD6;

/**
 * Created by flthiebl on 28/11/2016.
 */
public class UneTache extends Thread {
    char monChar;
    Semaphore gauche;
    Semaphore droite;
    Flag stop;

    public UneTache(char monChar, Semaphore gauche, Semaphore droite, Flag stop) {
        this.monChar = monChar;
        this.gauche = gauche;
        this.droite = droite;
        this.stop = stop;
    }

    public void run(){
        while (!stop.estLeve()){
            /*gauche.P();
            System.out.println(monChar);
            try {
                sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            droite.V();*/
        }
    }
}
