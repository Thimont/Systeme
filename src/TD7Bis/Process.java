package TD7Bis;

class Process {
    MsgQueue In;
    MsgQueue Out;
    public Process(MsgQueue i,MsgQueue o) {
        In=i;
        Out=o;
    }
    public void send(int x) {
        Out.send(new Integer(x));
    }
    public int recv() {
        Object x = In.recv();
        while (x==null)
            x=In.recv();
        int res = ((Integer) x).intValue();
        return res;
    }
}