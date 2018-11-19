package oppgave2;

public class Producer extends Thread{
    private BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do{
            buffer.produser();
        }while (true);

    }
}
