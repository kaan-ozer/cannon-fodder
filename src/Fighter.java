import java.security.SecureRandom;

public class Fighter extends Character{

    public Fighter(int strength, int vitality, int intelligence) {

        super(strength,
                vitality,
                intelligence);

    }

    //it will show the information of the Fighter
    public void showInfos() {
        System.out.println("Character's type is Fighter...");
        System.out.println("Fighter's strength is: " + getStrength());
        System.out.println("Fighter's intelligence is: " + getIntelligence());
        System.out.println("Fighter's vitality is: " + getVitality());
        System.out.println("Fighter's hp is: " + getHp());
    }

}
