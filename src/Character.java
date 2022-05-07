import java.security.SecureRandom;

public abstract class Character {

    private int strength;
    private int vitality;
    private int intelligence;
    private long hp;


    public abstract void showInfos();

    public Character(int strength, int vitality, int intelligence ) {

     setStrength(strength);
     setVitality(vitality);
     setIntelligence(intelligence);

     setHp(calculateHp(getStrength(),getVitality(),getIntelligence()));
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
    public long calculateHp(int strength, int vitality, int intelligence){   //method for calculation of health point

        hp= Math.round(0.7*strength + 0.2*vitality + 0.1*intelligence);

        return hp;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }
}
