package TD7Bis;

import java.util.*;

class MsgQueue {
    Vector queue = new Vector() ;
    public synchronized void send(Object obj) {
        queue.addElement(obj);
    }
    public synchronized Object recv() {
        if (queue.size()==0)
            return null;
        Object obj = queue.firstElement();
        queue.removeElementAt(0);
        return obj;
    }
    public synchronized int size() {
        return queue.size();
    }
}
