package TDLecteurRedacteur;

public class Lecteur extends Thread {
    private LecteursRedacteurs ES;
    int tempsLecture;
    boolean stop = false;
    int nbLecture = 0;
    String nameLecteur;

    public Lecteur(LecteursRedacteurs base, int tpsLect, String nameLecteur) {
        this.ES = base;
        this.tempsLecture = tpsLect;
        this.nameLecteur = nameLecteur;
    }

    public void Stop() {
        this.stop = true;
    }

    public void run() {
        ES.entreLecture();
        while (!stop) {
            nbLecture++;
            try {
                sleep(this.tempsLecture);
            } catch (InterruptedException e) {
            }
            ES.sortLecture();
        }
    }
}

