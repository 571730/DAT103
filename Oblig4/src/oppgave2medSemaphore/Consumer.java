package oppgave2medSemaphore;

public class Consumer extends Thread{
    BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do{
            buffer.consume();
        }while (true);
    }
}
