import java.security.SecureRandom;
import java.util.ArrayList;

public abstract class Character {

    private int strength;
    private int vitality;
    private int intelligence;
    private long hp;
    // each character has an inventory which holds items
    private ArrayList<Item> inventory = new ArrayList<>();


    public abstract void showInfos();

    public Character(SecureRandom randomNumber) {

        this.setStrength(0);  // page 3 of the project instruction (based on table values)
        this.setVitality(0);
        this.setIntelligence(0);
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
    public long calculateHp(int strength,int vitality, int intelligence){   //method for calculation of health point

        long hp= Math.round(0.7*vitality+0.2*strength+0.1*intelligence);

        return hp;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }
}
