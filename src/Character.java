import java.security.SecureRandom;
import java.util.ArrayList;

public abstract class Character {

    private int strength;
    private int vitality;
    private int intelligence;
    private long hp;
    protected  int startOfInterval ; ////////*******  this data member determines the beginning of the "random number " interval
    protected  int endOfInterval;//////    this data member determines the end  of the "random number " interval.
    // for example if strength should be a random value between inter val ( x , y ) the rangeFrom data member is x and rangeTo data member will be y



    public int generateRandomNumber(int startOfInterval,int endOfInterval){ //  this  method makes randomNumbers based on the  intervals of numbers
        SecureRandom randomNumber=new SecureRandom();
        int randomValue= startOfInterval+randomNumber.nextInt(endOfInterval);
        return  randomValue;


    }


    ////my changes


    public int getStartOfInterval() {
        return startOfInterval;
    }

    public int getEndOfInterval() {
        return endOfInterval;
    }

    // each character has an inventory which holds items
    private ArrayList<Item> inventory = new ArrayList<>();


    public abstract void showInfos();



    public Character(int strength,int vitality,int intelligence) {

        this.setStrength(generateRandomNumber(startOfInterval,endOfInterval));  // page 3 of the project instruction (based on table values)
        this.setVitality(generateRandomNumber(startOfInterval,endOfInterval));
        this.setIntelligence(generateRandomNumber(startOfInterval,endOfInterval));
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
