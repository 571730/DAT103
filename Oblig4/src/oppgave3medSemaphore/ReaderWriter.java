package oppgave3medSemaphore;

import java.util.concurrent.Semaphore;

public class ReaderWriter {
    private int read_count;
    private Semaphore rw_mutex;
    private Semaphore mutex;

    public ReaderWriter() {
        this.read_count = 0;
        this.rw_mutex = new Semaphore(1);
        this.mutex = new Semaphore(1);
    }

    void skriv(){
        try {
            rw_mutex.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Skriver..");
        rw_mutex.release();
    }

    void les(){
        try {
            mutex.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        read_count++;
        if (read_count == 1){
            try {
                rw_mutex.acquire();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        mutex.release();
        System.out.println("Leser..");
        read_count--;
        if (read_count == 0){
            rw_mutex.release();
        }
        mutex.release();
    }
}
