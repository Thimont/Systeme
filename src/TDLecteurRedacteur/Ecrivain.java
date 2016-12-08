package TDLecteurRedacteur;

public class Ecrivain extends Thread {
    private LecteursRedacteurs ES;
    int tempsEcriture;
    boolean stop = false;
    int nbEcriture = 0;
    String nameEcrivain;

    public Ecrivain(LecteursRedacteurs base, int tpsEcriture, String nameEcrivain) {
        this.ES = base;
        this.tempsEcriture = tpsEcriture;
        this.nameEcrivain = nameEcrivain;
    }

    public void Stop() {
        this.stop = true;
    }

    public void run() {
        while (!stop) {
            ES.entreEcriture();
            nbEcriture++;
            try {
                sleep(this.tempsEcriture);
            } catch (InterruptedException e) {
            }
            ES.sortEcriture();
        }
    }
}

