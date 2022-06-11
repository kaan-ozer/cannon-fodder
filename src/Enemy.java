import java.security.SecureRandom;
import java.util.Scanner;

public class Enemy extends Character{


    //constructor for Enemy

    public Enemy(int strength,int vitality,int intelligence) {

        // page 3 of the project instruction (based on table values)
        super(strength,vitality,intelligence);



        //setHP
        this.setHp(calculateHp(strength,vitality,intelligence) + 1   ,1,strength,vitality,intelligence);
        //SetRace
        setRace("enemy");


        SecureRandom randomNumber = new SecureRandom();

        //character will be born with an item which is given at the beginning
        int number =  1+ randomNumber.nextInt(101);




        if (number <= 80) {
            Sword longSword = new Sword("BrokenSword",2,0.3);
            setWeaponHoldingOnHand(longSword);
        }

        else if(number > 80 && number <= 90) {
            Wand boneWand=new Wand("BoneWand",1,0.6);
            setWeaponHoldingOnHand(boneWand);
        }

        else if(number > 90 && number <= 102){
            Shield  bucklerShieled=new Shield("BucklerShield",1,0.6);
            setWeaponHoldingOnHand(bucklerShieled);
        }
        else {
            System.out.println("there is a problem");
        }


    }

    public static Item itemDrop() {

        SecureRandom random = new SecureRandom();

        int number = random.nextInt(375);


        if (number <= 25) {
            Sword longSword = new Sword("longSword",2,0.6);
            return longSword;
        }

        else if(number > 25 && number <= 50) {
            Sword brokenSword = new Sword("brokenSword",1,0.3);
            return brokenSword;
        }

        else if( number > 50  && number <= 75 ) {
            Sword excalibur = new Sword("excalibur",3,0.9);
            return excalibur;
        }

        else if(number > 75 && number <= 100){
            Wand woodenWand=new Wand("woodenWand",1,0.3);
            return woodenWand;
        }
        else if(number > 100 && number <= 125){

            Wand boneWand=new Wand("boneWand", 2,0.6);
            return boneWand;
        }
        else if(number > 125 && number <= 150){
            Wand steelWand=new Wand("steelWand", 3,0.9);
            return steelWand;
        }
        else if(number > 150 && number <= 175){
            Shield  bucklerShieled=new Shield("bucklerShield",2,0.6);
            return bucklerShieled;
        }
        else if(number > 175 && number <= 200){
            Shield smallShield=new Shield("smallShield", 1,0.3);
            return smallShield;
        }
        else if(number > 200 && number <= 225){
            Shield towerShield =new Shield("towerShield", 1,0.9);
            return towerShield;
        }
        else if(number > 225 &&  number <= 275) {
            Armor chainArmor = new Armor("chainArmor" , 1 ,2);
            return chainArmor;
        }
        else if(number > 275 &&  number <= 325) {
            Armor medium_armor = new Armor("Medium Armor" , 2 ,3);
            return medium_armor;
        }
        else if(number > 325 &&  number <= 375) {
            Armor HeavyArmor = new Armor("Heavy Armor" , 3 ,4);
            return HeavyArmor;
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

    public void addItemToInventory(Item item) {

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

    public void wieldOrWear() {

        Scanner scanner = new Scanner(System.in);

        listInventory();

        System.out.println("Please choose the item via numbers");
        int decision = scanner.nextInt();
        int index = decision -1;

        if(getInventory().get(index) instanceof Weapon) {

            addItemToInventory(getWeaponHoldingOnHand());
            System.out.println(getWeaponHoldingOnHand().getName() + " which you hold before is added Enemy's inventory.");

            setWeaponHoldingOnHand((Weapon) (getInventory().get(index)));
            System.out.println(getInventory().get(index).getName() + " is wielded now");

            getInventory().remove(index);

        }

        else if(getInventory().get(index) instanceof Armor) {

            addItemToInventory(getArmorOnCharacter());
            System.out.println(getArmorOnCharacter().getName() + " which you hold before is added Enemy's inventory.");

            setArmorOnCharacter((Armor)(getInventory().get(index)));
            System.out.println(getInventory().get(index).getName() + " is wearing now");

            getInventory().remove(index);

        }
    }


}
