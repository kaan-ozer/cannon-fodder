import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public  class  Fighter extends Character{




    public Fighter(int strength,int vitality,int intelligence) {

        // page 3 of the project instruction (based on table values)
        super(strength,vitality,intelligence);

        //character will be born with an item which is given at the beginning
        Sword shortSword = new Sword("short sword", 1,0.3);
        setWeaponHoldingOnHand(shortSword);

        Armor lightArmor = new Armor("Light Armor", 1, 1);
        setArmorOnCharacter(lightArmor);

        //setHP
        this.setHp(calculateHp(strength,vitality,intelligence) + getArmorOnCharacter().getExtraHp(), getArmorOnCharacter().getExtraHp(),strength,vitality,intelligence);
        //SetRace
        setRace("Fighter");



    }

    //it will show the information of the Fighter
    public void showInfos() {

        System.out.println("Character's type is Fighter...");
        System.out.println("Fighter's strength is: " + getStrength());
        System.out.println("Fighter's intelligence is: " + getIntelligence());
        System.out.println("Fighter's vitality is: " + getVitality());
        System.out.println("Fighter's hp is: " + getHp());
    }

    public  void listInventory() {

        if (getInventory().size() == 0) {
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.println("There is no any item which assigned to Fighter right now.");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            return;
        }

        System.out.println();
        System.out.println("Fighter wields " + getWeaponHoldingOnHand().getName() + ",  wears " + getArmorOnCharacter().getName());
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
            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println(item.getName() + " has been added to Fighter's inventory");
        }

        else {

            System.out.println("the current weight of the inventory for the fighter is: " + calculateYourInventoryWeight());
            System.out.println("Fighter cannot carry much more than " + getStrength() + " as total value." );
            System.out.println("-----------------------------------------------");
            System.out.println();
        }

    }

    public void wieldOrWear() {

        Scanner scanner = new Scanner(System.in);

        int decision = 0;

        while (true) {

            listInventory();
            try {
                System.out.println("Please choose the item via numbers");
                decision = scanner.nextInt();
                System.out.println();
                break;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Please don't try to crash my program and enter integer :)");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println();
                continue;
            }


        }
        int index = decision -1;

        if(getInventory().get(index) instanceof Weapon) {

            addItemToInventory(getWeaponHoldingOnHand());
            System.out.println(getWeaponHoldingOnHand().getName() + " which you hold before is added Fighter's inventory.");

            setWeaponHoldingOnHand((Weapon) (getInventory().get(index)));
            System.out.println(getInventory().get(index).getName() + " is wielded now");

            getInventory().remove(index);

        }

        else if(getInventory().get(index) instanceof Armor) {

            addItemToInventory(getArmorOnCharacter());
            System.out.println(getArmorOnCharacter().getName() + " which you hold before is added Fighter's inventory.");

            setArmorOnCharacter((Armor)(getInventory().get(index)));
            System.out.println(getInventory().get(index).getName() + " is wearing now");

            getInventory().remove(index);

        }
    }




}
