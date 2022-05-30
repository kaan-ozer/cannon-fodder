import java.security.SecureRandom;
import java.util.Scanner;

public class Enemy extends Character{


    //constructor for Enemy

    public Enemy(int strength,int vitality,int intelligence) {

        // page 3 of the project instruction (based on table values)
        super(strength,vitality,intelligence);
        //setHP
        this.setHp(calculateHp(strength,vitality,intelligence),strength,vitality,intelligence);
        //SetRace
        setRace("enemy");


        SecureRandom randomNumber = new SecureRandom();

        //character will be born with an item which is given at the beginning
        int number =  1+ randomNumber.nextInt(101);

        if (number < 80) {
            Sword longSword = new Sword("longSword",2,2);
            setWeaponHoldingOnHand(longSword);
        }

        else if(number >= 80 && number <= 90) {
            Wand woodenWand=new Wand("woodenWand",1,1.5);
            setWeaponHoldingOnHand(woodenWand);
        }

        else if(number > 90 && number < 200){
            Shield  bucklerShieled=new Shield("bucklerShield",1,2);
            setWeaponHoldingOnHand(bucklerShieled);
        }
        else {
            System.out.println("there is a problem");
        }


    }

    public static Weapon dropWeapon() {

        SecureRandom random = new SecureRandom();

        int number = random.nextInt(101);

        if (number <= 24) {
            Sword longSword = new Sword("longSword",2,2);
            return longSword;
        }

        else if(number >= 25 && number <= 39) {
            Sword brokenSword = new Sword("brokenSword",1,1.2);
            return brokenSword;
        }

        else if( number >= 40  && number <= 45 ) {
            Sword excalibur = new Sword("excalibur",1,2.5);
            return excalibur;
        }

        else if(number < 70 && number > 45){
            Wand woodenWand=new Wand("woodenWand",1,1.5);
            return woodenWand;
        }
        else if(number < 90 && number >= 70){

            Wand boneWand=new Wand("boneWand", 2,2.3);
            return boneWand;
        }
        else if(number<65&& number < 80){
            Wand steelWand=new Wand("steelWand", 2,2.6);
            return steelWand;
        }
        else if(number<80 && number < 90){
            Shield  bucklerShieled=new Shield("bucklerShiled",1,2);
            return bucklerShieled;
        }
        else if(number<90 && number < 101){
            Shield smallShield=new Shield("smallShield", 2,1.5);
            return smallShield;
        }
        else {
            System.out.println("Drops nothing");
            return null;
        }

    }
    //it will show the information of the Enemy

    public void showInfos() {

        System.out.println("Character's type is Enemy...");
        System.out.println("Enemy's strength is: " + getStrength());
        System.out.println("Enemy's intelligence is: " + getIntelligence());
        System.out.println("Enemy's vitality is: " + getVitality());
        System.out.println("Enemy's hp is: " + getHp());
    }

    public  void listInventory() {

        if (getInventory().size() == 0) {
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.println("There is no any item which assigned to Enemy right now.");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            return;
        }


        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-17s " , "Item's name");
        System.out.printf("%-14s " ,"weight");
        System.out.printf("%-10s " , "value");
        System.out.println();


        for(int i = 0; i < getInventory().size() ; i++) {


            if (getInventory().get(i) != null){
                System.out.printf("%d. %-17s ", i + 1, getInventory().get(i).getName());
                System.out.printf("%-14s ", getInventory().get(i).getWeight());
                System.out.printf("%-10s ", getInventory().get(i).getValue());
                System.out.println();

            }

        }
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public void addItemToInventory(Weapon item) {

        //character try to take an item and we calculate the totalweight.
        double updatedWeightInInventory = item.weight + calculateYourInventoryWeight();

        //Character cannot carry much more than itself's strength
        if (updatedWeightInInventory < getStrength()) {
            getInventory().add(item);
            System.out.println(item.getName() + " has been added to Enemy's inventory");
        }

        else {

            System.out.println("the current weight of the inventory for the Enemy is: " + calculateYourInventoryWeight());
            System.out.println("Enemy cannot carry much more than " + getStrength() + " as total value." );
        }

    }

    public void wield() {

        Scanner scanner = new Scanner(System.in);

        listInventory();

        System.out.println("Please choose the item via numbers");
        int decision = scanner.nextInt();
        int index = decision -1;


        addItemToInventory(getWeaponHoldingOnHand());
        System.out.println(getWeaponHoldingOnHand().getName() + " which you hold before is added Enemy's inventory.");

        setWeaponHoldingOnHand(getInventory().get(index));
        System.out.println(getInventory().get(index).getName() + " is wielded now");

        getInventory().remove(index);
    }


}
