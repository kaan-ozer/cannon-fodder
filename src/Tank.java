import  java.security.SecureRandom;
public class Tank extends Character {
    SecureRandom randomNumber =new SecureRandom();

    //constructor for tank, tank is a character, and we used the character's constructor via super.
    public Tank(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);
        this.setStrength(1+randomNumber.nextInt(5));  // page 3 of the project instruction (based on table values)
        this.setVitality(6+randomNumber.nextInt(10));
        this.setIntelligence(3+randomNumber.nextInt(7));
    }

    //default constructor
    public Tank() {
        super(0,0,0);
    }
}
