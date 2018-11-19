package oppgave2medSemaphore;

public class Main {
    public static void main(String[] args){
        BoundedBuffer buffer = new BoundedBuffer();
        Consumer c1 = new Consumer(buffer);
        Producer p1 = new Producer(buffer);
        c1.start();
        p1.start();
    }
}
