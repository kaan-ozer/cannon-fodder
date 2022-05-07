import  java.security.SecureRandom;
public class Fighter extends Character{
    SecureRandom randomNumber =new SecureRandom(); // we make object of class secureRandom to assign random values to strength_intelligence and vitality

    //constructor for fighter, fighter is a character, and we used the character's constructor via super.
    public Fighter(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);


        this.setStrength(6+randomNumber.nextInt(10));  // page 3 of the project instruction (based on table values)
        this.setVitality(3+randomNumber.nextInt(7));
        this.setIntelligence(1+randomNumber.nextInt(5));

    }

    //default constructor
    public Fighter() {
        super(0,0,0);
    }
}
