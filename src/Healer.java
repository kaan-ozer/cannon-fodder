import  java.security.SecureRandom;
 public class Healer extends Character{
     SecureRandom randomNumber =new SecureRandom();

     //constructor for healer, healer is a character, and we used the character's constructor via super.
    public Healer(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);

        this.setStrength(3+randomNumber.nextInt(7));  // page 3 of the project instruction (based on table values)
        this.setVitality(1+randomNumber.nextInt(5));
        this.setIntelligence(6+randomNumber.nextInt(10));
    }

    //default constructor
    public Healer() {
        super(0,0,0);
    }
}
