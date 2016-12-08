package TDLecteurRedacteur;

public class TheMain {

    public static void main(final String[] args) throws InterruptedException {
        LecteursRedacteurs base = new LecteursRedacteurs2();
        int tpsL = 10;
        int tpsEcrt = 100;
        int nbLect = 100;
        String name = "toto";
        Ecrivain E = new Ecrivain(base, tpsEcrt, name) ;
        Lecteur[] TabL = new Lecteur[nbLect];

        for (int i = 0; i < nbLect; i++) {
            TabL[i] = new Lecteur(base, tpsL, name);
            TabL[i].start();
        }
        E.start();
        Thread.sleep(1000 * 10);
        E.Stop();
        int minL = 100000;
        int maxL = 0;
        for (int i = 0; i < nbLect; i++) {
            TabL[i].Stop();
            if (TabL[i].nbLecture > maxL) maxL = TabL[i].nbLecture;
            if (TabL[i].nbLecture<minL) minL = TabL[i].nbLecture;
        }
        System.out.println("minL="+minL+ " maxL="+maxL + " /"+1000 * 10/tpsL);
        System.out.println("NBE = " + E.nbEcriture + "/"+1000 * 10/tpsEcrt);
    }
}

