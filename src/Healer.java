import java.security.SecureRandom;

public class Healer extends Character{
/*
    //constructor for healer
    public Healer(SecureRandom randomNumber) {
        super(randomNumber);
        setHp(calculateHp());
    }*/

    //it will show the information of the healer
    public void showInfos() {
        System.out.println("Character's type is Healer...");
        System.out.println("Healer's strength is: " + getStrength());
        System.out.println("Healer's intelligence is: " + getIntelligence());
        System.out.println("Healer's vitality is: " + getVitality());
        System.out.println("Healer's hp is: " + getHp());
    }


}
