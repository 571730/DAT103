package oppgave4medSeamphore;


public class Filosof extends Thread{
    private int plass;
    private DiningPhil buffer;

    public Filosof(int plass, DiningPhil buffer){
        this.plass = plass;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        do{
            buffer.spis(plass);
        }while (true);
    }
}
