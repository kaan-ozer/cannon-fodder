import java.security.SecureRandom;
import java.util.ArrayList;

public abstract class Character {

    private int strength;
    private int vitality;
    private int intelligence;
    private long hp;
    private Item itemHoldingOnHand;
    private boolean doesItLive;
    private String race;
    // each character has an inventory which holds items
    private ArrayList<Item> inventory;


    public abstract void showInfos();

    public Character(int strength,int vitality,int intelligence) {

        this.strength = strength;  // page 3 of the project instruction (based on table values)
        this.vitality = vitality;
        this.intelligence = intelligence;
        setHp(calculateHp(strength,vitality,intelligence));
        this.race = null;
        this.doesItLive = true;
        this.itemHoldingOnHand = null;
        this.inventory = new ArrayList<>();
    }

    //default constructor
    public Character() {
        this.strength = 0;
        this.vitality = 0;
        this.intelligence = 0;
        setHp(calculateHp(0,0,0));
        this.itemHoldingOnHand = null;
        this.race = null;
        this.doesItLive = true;
        this.itemHoldingOnHand = null;
        this.inventory = new ArrayList<>();
    }

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

    public void addItemToInventory(Character character, Item item) {

        //character try to take an item and we calculate the totalweight.
        double updatedWeightInInventory = item.weight + calculateYourInventoryWeight();

        //Character cannot carry much more than itself's strength
        if (updatedWeightInInventory < character.getStrength()) {
            System.out.println(item.getName() + " added to the inventory.");
            character.getInventory().add(item);
        }
        else {
            System.out.println("Character cannot carry much more than itself's strength which be " + character.getStrength() );
            System.out.println("Your inventory's current weight is: " + calculateYourInventoryWeight());
        }

    }


    //getter and setters


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isDoesItLive() {
        return doesItLive;
    }

    public void setDoesItLive(boolean doesItLive) {
        this.doesItLive = doesItLive;
    }

    public Item getItemHoldingOnHand() {
        return itemHoldingOnHand;
    }

    public void setItemHoldingOnHand(Item itemHoldingOnHand) {
        this.itemHoldingOnHand = itemHoldingOnHand;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
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

    // it will calculate and return the hp value which its type is long.
    public long calculateHp(int strength,int vitality, int intelligence){   //method for calculation of health point

        long hp= Math.round(0.7*vitality+0.2*strength+0.1*intelligence);

        return hp;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        if ((getHp() - hp) < 0 ) {
            System.out.println("Warrior is dead");
            setDoesItLive(false);
        }
        else {
            this.hp = hp;
        }

    }
}
