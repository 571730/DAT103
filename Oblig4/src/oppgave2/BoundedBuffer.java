package oppgave2;

public class BoundedBuffer {
    private int S;
    private final int MAX;
    private FullSemafor full;
    private TomSemafor tom;
    private Mutex mutex;

    public BoundedBuffer(int MAX){
        this.S = 0;
        this.MAX = MAX;
        this.full = new FullSemafor(MAX);
        this.tom = new TomSemafor();
        this.mutex = new Mutex();
    }

    void konsumer(){
        full.vent();
        mutex.vent();
        System.out.println("Konsumerte");
        S--;
        mutex.signal();
        tom.signal();
    }

    void produser(){
        tom.vent();
        mutex.vent();
        System.out.println("Produserte");
        S++;
        mutex.signal();
        full.signal();
    }

    public int getS(){return S;}
}
