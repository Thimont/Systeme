package TD7Bis;

class Eratosthene {
    public static void main(String[] args){
        MsgQueue mq = new MsgQueue();
        new Generateur(100,mq).start();
        new Filtre(mq).run();
    }
}
