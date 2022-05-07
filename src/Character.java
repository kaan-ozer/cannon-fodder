
public abstract class Character {

    private int strength;
    private int vitality;
    private int intelligence;
    private long hp;




    public Character(int strength, int vitality, int intelligence) {


        this.strength = strength;
        this.vitality = vitality;
        this.intelligence = intelligence;
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

    public void calculateHp(){   //method for calculation of health point
       hp= Math.round(0.7*getVitality()+0.2*getStrength()+0.1*getIntelligence());

    }
}
