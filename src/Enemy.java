import java.security.SecureRandom;

public class Enemy extends  Character{

    //constructor for Enemy

    public Enemy(SecureRandom randomNumber) {
        // page 3 of the project instruction (based on table values)

        //str must be between 1-5 for the Enemy
        int strength = 1+randomNumber.nextInt(5);
        //vitality must be between 1-5 for the Enemy
        int vitality = 1+randomNumber.nextInt(5);
        //intelligence must be between 1-5 for the fighter
        int intelligence = 1+randomNumber.nextInt(5);

        this.setStrength(strength);
        this.setVitality(vitality);
        this.setIntelligence(intelligence);

        //set HP
        this.setHp(calculateHp(strength,vitality,intelligence));
    }


    //it will show the information of the Enemy
    public void showInfos() {
        System.out.println("Character's type is Enemy...");
        System.out.println("Enemy's strength is: " + getStrength());
        System.out.println("Enemy's intelligence is: " + getIntelligence());
        System.out.println("Enemy's vitality is: " + getVitality());
        System.out.println("Enemy's hp is: " + getHp());
    }
}
