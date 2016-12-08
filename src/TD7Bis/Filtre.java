package TD7Bis;

class Filtre extends Thread {
    int filtre;
    Process p;
    Filtre(MsgQueue mq) {
        p=new Process(mq,new MsgQueue());
    }
    public void run() {
        int i;
        filtre = p.recv();
        if (filtre != -1) {
            System.out.println(filtre);
            new Filtre(p.Out).start();
            i=p.recv();
            while (i!=-1) {
                if (i % filtre != 0) {
                    p.send(i);
                }
                i=p.recv();
            }
            p.send(-1);
        }
    }
}
