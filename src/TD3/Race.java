package TD3;

/**
 * Created by flthiebl on 30/09/2016.
 */
public class Race {

    static Double val = 0.0;
    SemBinaire sb = new SemBinaire();

    public class Thread_plus extends Thread {
        public void run(){
            for (int i = 0; i < 100000; i++){
                sb.P();
                val += 1.0;
                sb.V();
            }
        }
    }

    public class Thread_moins extends Thread {
        public void run(){
            for (int i = 0; i < 100000; i++){
                sb.P();
                val -= 1.0;
                sb.V();
            }
        }
    }

    public void go() throws InterruptedException {
        Thread_plus tp = new Thread_plus();
        Thread_moins tm = new Thread_moins();

        sb.E0(1);

        tp.start();
        tm.start();
        tp.join();
        tm.join();

        System.out.println(val);
    }

    public static void main(String[] args) throws InterruptedException {
        Race r = new Race();
        r.go();
    }
}
