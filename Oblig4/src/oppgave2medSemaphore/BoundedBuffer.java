package oppgave2medSemaphore;

import java.util.concurrent.Semaphore;

public class BoundedBuffer {
    private Semaphore semCon;
    private Semaphore semProd;

    public BoundedBuffer(){
        semCon = new Semaphore(0);
        semProd = new Semaphore(1);
    }

    void consume(){
        try {
            semCon.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Konsumerte enhet");
        semProd.release();
    }

    void produce(){
        try {
            semProd.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Produserte enhet");
        semCon.release();
    }
}
