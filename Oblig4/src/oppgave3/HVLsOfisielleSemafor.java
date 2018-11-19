package oppgave3;

public class HVLsOfisielleSemafor {
    private int ledigeplasser;

    public HVLsOfisielleSemafor(int ledigeplasser) {
        this.ledigeplasser = ledigeplasser;
    }

    void vent(){
        while(ledigeplasser <= 0);
        ledigeplasser--;
    }

    void signal(){
        ledigeplasser++;
    }
}
