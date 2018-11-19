package oppgave4medSeamphore;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhil {
    private Semaphore spisepinner[];

    public DiningPhil(){
        spisepinner = new Semaphore[5];
        for(int i = 0; i < spisepinner.length; i++){
            spisepinner[i] = new Semaphore(1);
        }
    }

    void spis(int i){
        if (i % 2 == 0){
            System.out.println("Filosof " + i + " venter..");
            try{
                spisepinner[i].acquire();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Filosof " + i + " holder spisepinn " + i +
                    " og venter på spisepinn " + ((i+1)%5));
            try{
                spisepinner[(i + 1) % 5].acquire();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }else {
            System.out.println("Filosof " + i + " venter..");
            try{
                spisepinner[i].acquire();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Filosof " + i + " holder spisepinn " + i +
                    " og venter på spisepinn " + ((i-1)%5));
            try{
                spisepinner[(i - 1) % 5].acquire();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Filosof " + i + " spiser");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (i % 2 == 0){
            spisepinner[i].release();
            spisepinner[i + 1 % 5].release();
        } else {
            spisepinner[i].release();
            spisepinner[(i - 1) % 5].release();
        }

        System.out.println("Filosof " + i + " tenker");
        try{
            Random random = new Random();
            Thread.sleep(random.nextInt(4000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
