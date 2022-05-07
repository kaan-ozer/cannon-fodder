import java.security.SecureRandom;

public abstract class Character {

    private int strength;
    private int vitality;
    private int intelligence;
    private long hp;


    public abstract void showInfos();

    public Character(SecureRandom randomNumber) {

        this.setStrength(6+randomNumber.nextInt(10));  // page 3 of the project instruction (based on table values)
        this.setVitality(3+randomNumber.nextInt(7));
        this.setIntelligence(1+randomNumber.nextInt(5));
    }

    //default constructor
    public Character() {
        this.strength = 0;
        this.vitality = 0;
        this.intelligence = 0;
    }

    //getter and setters
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    // it will calculate and return the hp value which its type is long.
    public long calculateHp(){   //method for calculation of health point

        hp= Math.round(0.7*getVitality()+0.2*getStrength()+0.1*getIntelligence());

        return hp;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }
}
