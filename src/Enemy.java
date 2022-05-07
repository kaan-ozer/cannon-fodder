import  java.security.SecureRandom;

public class Enemy extends  Character{
    SecureRandom randomNumber =new SecureRandom();

    public Enemy(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);

        this.setStrength(1+randomNumber.nextInt(5));  // page 3 of the project instruction (based on table values)
        this.setVitality(1+randomNumber.nextInt(5));
        this.setIntelligence(1+randomNumber.nextInt(5));
    }

    public Enemy() {
        super(0,0,0);
    }
}
