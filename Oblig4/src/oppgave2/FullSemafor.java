package oppgave2;

public class FullSemafor {
    private int full;
    private int brukt;

    public FullSemafor(int full) {
        this.full = full;
        this.brukt = 0;
    }

    void vent(){
        while (brukt >= full);
        brukt++;
    }

    void signal(){
        brukt--;
    }
}
