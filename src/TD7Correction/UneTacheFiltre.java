package TD7Correction;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by flthiebl on 01/12/2016.
 */
public class UneTacheFiltre extends Thread {

    private Integer monNombre;
    private ArrayBlockingQueue<Integer> bufG;
    private ArrayBlockingQueue<Integer> bufD;
    private boolean stop;

    public UneTacheFiltre(ArrayBlockingQueue bufG, Integer nombre) {
        this.bufG = bufG;
        this.monNombre = nombre;
        this.bufD = null;
        this.stop = false;
    }

    public void run() {
        Integer nombreLu = -1;
        System.out.println("Debut tache " + monNombre);
        try {
            while (nombreLu != 0) {
                nombreLu = bufG.take();

                if(nombreLu % monNombre != 0){
                    System.out.println("Tache " + monNombre + " a lu " + nombreLu);
                    if(bufD == null) {
                        System.out.println("On cree une tache");

                        bufD = new ArrayBlockingQueue<Integer>(1);
                        UneTacheFiltre t = new UneTacheFiltre(bufD, nombreLu);
                        t.start();
                    }
                    bufD.put(nombreLu);
                }
            }

            System.out.println(monNombre);
            if(bufD != null) {
                bufD.put(new Integer(0));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
