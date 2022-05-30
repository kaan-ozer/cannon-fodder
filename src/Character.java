import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {

    //we have to add these
    private int strength;
    private int vitality;
    private int intelligence;
    private double hp;

    //extra features
    private boolean isCharacterTired;
    private Weapon weaponHoldingOnHand;
    private boolean isItAlive;
    private String race;
    // each character has an inventory which holds items
    private ArrayList<Weapon> inventory;

    //CONSTRUCTORS

    public Character(int strength,int vitality,int intelligence) {

        //main data members
        this.strength = strength;  // page 3 of the project instruction (based on table values)
        this.vitality = vitality;
        this.intelligence = intelligence;
        this.hp = 0;
        //extra data members
        this.isCharacterTired=false;
        this.race = null;
        this.isItAlive = true;
        this.weaponHoldingOnHand = null;
        //inventory for each character
        this.inventory = new ArrayList<>();
    }

    //default constructor
    public Character() {
        this.strength = 0;
        this.vitality = 0;
        this.intelligence = 0;
        this.hp = 0;
        this.weaponHoldingOnHand = null;
        this.race = null;
        this.isItAlive = true;
        this.inventory = new ArrayList<>();
    }


    //METHODS

    public abstract void showInfos();

    public abstract void wield();

    public abstract void listInventory();

    public abstract void addItemToInventory(Weapon item);

    public double calculateYourInventoryWeight() {

        double totalWeightInInventory =0;

        for (int i = 0; i < getInventory().size() ; i++) {
            //if there is an item add its weight to the total weight
            if (getInventory().get(i) != null) {
                totalWeightInInventory += getInventory().get(i).getValue();
            }
        }

        return totalWeightInInventory;
    }

    public void removeItemFromInventory(Weapon item) {

        for (int i = 0 ; i < getInventory().size() ; i++) {
            if (getInventory().get(i) == item)
            getInventory().remove(i);
        }

    }

    // it will calculate and return the hp value which its type is long.
    public long calculateHp(int strength,int vitality, int intelligence){   //method for calculation of health point

        long hp= Math.round(0.7*vitality+0.2*strength+0.1*intelligence);

        return hp;
    }


    //GETTER AND SETTERS


    public boolean isCharacterTired() {
        return isCharacterTired;
    }

    public void setCharacterTired(boolean characterTired) {
        isCharacterTired = characterTired;
    }

    public boolean isItAlive() {
        return isItAlive;
    }

    public void setItAlive(boolean itAlive) {
        isItAlive = itAlive;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Weapon getWeaponHoldingOnHand() {
        return weaponHoldingOnHand;
    }

    public void setWeaponHoldingOnHand(Weapon weaponHoldingOnHand) {
        this.weaponHoldingOnHand = weaponHoldingOnHand;
    }

    public ArrayList<Weapon> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Weapon> inventory) {
        this.inventory = inventory;
    }

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

    public double getHp() {
        return hp;
    }

    public void setHp(double hp,int strength,int vitality,int intelligence) {

        double boundary = calculateHp(strength,vitality,intelligence);

        if (hp < boundary)
            this.hp = hp;
        else
            this.hp = boundary;


    }
}
