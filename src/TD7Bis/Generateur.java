package TD7Bis;

class Generateur extends Thread {
    int n;
    Process p;
    Generateur(int max,MsgQueue mq) {
        n=max;
        p=new Process(null,mq);
    }
    public void run() {
        for(int i=2;i<=n;i++) {
            p.send(i);
        }
        p.send(-1);
    }
}
