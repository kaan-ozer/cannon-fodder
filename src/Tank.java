import java.security.SecureRandom;

public class Tank extends Character {

    //constructor for Tank
    public Tank(SecureRandom randomNumber) {
        // page 3 of the project instruction (based on table values)

        //str must be between 3-7 for the Healer
        int strength = 1+randomNumber.nextInt(5);
        //vitality must be between 6-10 for the Tank
        int vitality = 6+randomNumber.nextInt(5);
        //vitality must be between 3-7 for the Tank
        int intelligence = 3+randomNumber.nextInt(5);


        this.setStrength(strength);
        this.setVitality(vitality);
        this.setIntelligence(intelligence);

        //set HP
        this.setHp(calculateHp(strength,vitality,intelligence));
    }



    //it will show the information of the Tank
    public void showInfos() {
        System.out.println("Character's type is Tank...");
        System.out.println("Tank's strength is: " + getStrength());
        System.out.println("Tank's intelligence is: " + getIntelligence());
        System.out.println("Tank's vitality is: " + getVitality());
        System.out.println("Tank's hp is: " + getHp());
    }
}
