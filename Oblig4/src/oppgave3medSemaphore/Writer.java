package oppgave3medSemaphore;

public class Writer extends Thread{
    private ReaderWriter rwBuffer;

    public Writer(ReaderWriter rwBuffer){
        this.rwBuffer = rwBuffer;
    }

    @Override
    public void run() {
        do{
            rwBuffer.skriv();
        }while (true);
    }
}
