import java.security.SecureRandom;

public class Tank extends Character {
/*
    //constructor for Tank
    public Tank(SecureRandom randomNumber) {
        super(randomNumber);
        setHp(calculateHp());
    }

 */

    //it will show the information of the Tank
    public void showInfos() {
        System.out.println("Character's type is Tank...");
        System.out.println("Tank's strength is: " + getStrength());
        System.out.println("Tank's intelligence is: " + getIntelligence());
        System.out.println("Tank's vitality is: " + getVitality());
        System.out.println("Tank's hp is: " + getHp());
    }
}
