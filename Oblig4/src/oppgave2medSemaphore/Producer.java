package oppgave2medSemaphore;

public class Producer extends Thread{
    BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do{
            buffer.produce();
        }while (true);
    }
}
