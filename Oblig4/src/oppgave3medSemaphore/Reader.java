package oppgave3medSemaphore;

public class Reader extends Thread{
    private  ReaderWriter rwBuffer;

    public Reader(ReaderWriter rwBuffer){
        this.rwBuffer = rwBuffer;
    }

    @Override
    public void run() {
        do{
            rwBuffer.les();
        }while (true);
    }
}
