package TD6;

/**
 * Created by flthiebl on 28/11/2016.
 */
public class Flag {
    private Boolean set;

    public Flag(Boolean set) {
        this.set = set;
    }

    public synchronized void leve(){
        this.set = true;
    }

    public synchronized Boolean estLeve(){
        return set;
    }
}
