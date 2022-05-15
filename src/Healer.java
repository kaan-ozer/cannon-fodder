import java.security.SecureRandom;

public class Healer extends Character{

    //constructor for healer
    public Healer(SecureRandom randomNumber) {
        // page 3 of the project instruction (based on table values)

        //str must be between 3-7 for the Healer
        int strength = 3+randomNumber.nextInt(5);
        //vitality must be between 1-5 for the Healer
        int vitality = 1+randomNumber.nextInt(5);
        //vitality must be between 6-10 for the Healer
        int intelligence = 6+randomNumber.nextInt(5);


        this.setStrength(strength);
        this.setVitality(vitality);
        this.setIntelligence(intelligence);
        //set HP
        this.setHp(calculateHp(strength,vitality,intelligence));
    }

    //it will show the information of the healer
    public void showInfos() {
        System.out.println("Character's type is Healer...");
        System.out.println("Healer's strength is: " + getStrength());
        System.out.println("Healer's intelligence is: " + getIntelligence());
        System.out.println("Healer's vitality is: " + getVitality());
        System.out.println("Healer's hp is: " + getHp());
    }


}
