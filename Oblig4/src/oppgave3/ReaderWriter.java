package oppgave3;

public class ReaderWriter {
    private HVLsOfisielleSemafor rw_mutex;
    private HVLsOfisielleSemafor mutex;
    private int read_count;

    public ReaderWriter() {
        this.rw_mutex = new HVLsOfisielleSemafor(1);
        this.mutex = new HVLsOfisielleSemafor(1);
        this.read_count = 0;
    }

    void skriv(){
        rw_mutex.vent();
        System.out.println("Skriver..");
        rw_mutex.signal();
    }

    void les(){
        mutex.vent();
        read_count++;
        if (read_count == 1){
            rw_mutex.vent();
        }
        mutex.signal();
        System.out.println("Leser..");
        read_count--;
        if (read_count == 0){
            rw_mutex.signal();
        }
        mutex.signal();
    }
}
