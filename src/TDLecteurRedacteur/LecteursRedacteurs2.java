package TDLecteurRedacteur;

import java.util.concurrent.Semaphore;

/**
 * Created by flthiebl on 05/12/2016.
 */
public class LecteursRedacteurs2 implements LecteursRedacteurs {
    Semaphore sem_glob;
    Semaphore s_att_lire;
    int nbLecteurs;
    int nbRedacteurs;
    boolean redacteurPresent;

    public LecteursRedacteurs2() {
        this.sem_glob = new Semaphore(1);
        this.s_att_lire = new Semaphore(1);
        this.nbLecteurs = 0;
    }

    @Override
    synchronized public void entreLecture() {
        try {
            s_att_lire.acquire();
            if(nbLecteurs == 0) {
                sem_glob.acquire();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nbLecteurs++;
        s_att_lire.release();
        if(nbLecteurs != 0 || nbLecteurs != 1){
            System.out.println("Violation nb lecteurs : " + nbLecteurs);
        }
        /*while (this.redacteurPresent)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        nbLecteurs++;*/
    }

    @Override
    synchronized public void sortLecture() {
        /*nbLecteurs--;
        notify();*/
        try {
            s_att_lire.acquire();
            nbLecteurs--;
            if(nbLecteurs == 0) {
                sem_glob.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s_att_lire.release();
        if(nbLecteurs != 0 || nbLecteurs != 1){
            System.out.println("Violation nb lecteurs : " + nbLecteurs);
        }

    }

    @Override
    synchronized public void entreEcriture() {
        try {
            sem_glob.acquire();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        /*while ((this.redacteurPresent)|| (this.nbLecteurs > 0))
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.redacteurPresent = true;*/
    }

    @Override
    synchronized public void sortEcriture() {
        sem_glob.release();
        /*this.redacteurPresent = false;
        notify();*/
    }
}
