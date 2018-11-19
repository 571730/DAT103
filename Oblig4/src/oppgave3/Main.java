package oppgave3;

public class Main {
    public static void main(String[] args) {
        ReaderWriter buffer = new ReaderWriter();
        Reader r1 = new Reader(buffer);
        Writer w1 = new Writer(buffer);

        r1.start();
        w1.start();
    }
}
