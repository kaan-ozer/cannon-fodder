import java.security.SecureRandom;

public class Fighter extends Character{



    public Fighter(SecureRandom randomNumber) {
    // page 3 of the project instruction (based on table values)
        int strength = 6+randomNumber.nextInt(5);
        int vitality = 3+randomNumber.nextInt(5);
        int intelligence = 1+randomNumber.nextInt(5);

        //str must be between 6-10 for the fighter
        this.setStrength(strength);
        //vitality must be between 3-7 for the fighter
        this.setVitality(vitality);
        //vitality must be between 1-5 for the fighter
        this.setIntelligence(intelligence);
        //set HP
        this.setHp(calculateHp(strength,vitality,intelligence));
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
