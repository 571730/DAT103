package oppgave2;

public class Consumer extends Thread {
    private BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do {
            buffer.konsumer();
        }while (true);
    }
}
