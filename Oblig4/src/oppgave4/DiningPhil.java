package oppgave4;

import java.util.Random;

public class DiningPhil {
    private HVLsOfisielleSemafor spisepinner[];

    public DiningPhil(){
        spisepinner = new HVLsOfisielleSemafor[5];
        for(int i = 0; i < spisepinner.length; i++){
            spisepinner[i] = new HVLsOfisielleSemafor(1);
        }
    }

    void spis(int i){
        if (i % 2 == 0){
            System.out.println("Filosof " + i + " venter..");
            spisepinner[i].vent();
            System.out.println("Filosof " + i + " holder spisepinn " + i +
                    " og venter på spisepinn " + ((i+1)%5));
            spisepinner[(i + 1) % 5].vent();
        }else {
            System.out.println("Filosof " + i + " venter..");
            spisepinner[i].vent();
            System.out.println("Filosof " + i + " holder spisepinn " + i +
                    " og venter på spisepinn " + ((i-1)%5));
            spisepinner[(i - 1) % 5].vent();
        }
        System.out.println("Filosof " + i + " spiser");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (i % 2 == 0){
            spisepinner[i].signal();
            spisepinner[i + 1 % 5].signal();
        } else {
            spisepinner[i].signal();
            spisepinner[(i - 1) % 5].signal();
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
