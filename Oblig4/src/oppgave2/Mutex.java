package oppgave2;

public class Mutex {
    private int ledig;

    public Mutex(){
        this.ledig = 1;
    }
    void vent(){
        while (ledig == 0);
        ledig = 0;
    }
    void signal(){
        ledig = 1;
    }
}
