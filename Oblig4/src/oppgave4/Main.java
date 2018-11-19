package oppgave4;

public class Main {
    public static void main(String[] args) {
        DiningPhil dinnerTable = new DiningPhil();
        Filosof f1 = new Filosof(0, dinnerTable);
        Filosof f2 = new Filosof(1, dinnerTable);
        Filosof f3 = new Filosof(2, dinnerTable);
        Filosof f4 = new Filosof(3, dinnerTable);
        Filosof f5 = new Filosof(4, dinnerTable);

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}
