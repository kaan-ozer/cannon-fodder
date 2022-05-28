import java.security.SecureRandom;
import java.util.Scanner;

public class Tank extends Character {

    public Tank(int strength,int vitality,int intelligence){

        super(strength,vitality,intelligence);

        this.setHp(calculateHp(strength,vitality,intelligence),strength,vitality,intelligence);

        setRace("Tank");

        Shield shield = new Shield("shield",1,0.5);
        setItemHoldingOnHand(shield);
    }

    public void showInfos(){

        System.out.println("Character's type is Tank...");
        System.out.println("Tank's strength is: " + getStrength());
        System.out.println("Tank's intelligence is: " + getIntelligence());
        System.out.println("Tank's vitality is: " + getVitality());
        System.out.println("Tank's hp is: " + getHp());
    }

    public  void listInventory() {

        if (getInventory().size() == 0) {
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.println("There is no any item which assigned to Tank right now.");
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
            System.out.println(item.getName() + " has been added to Tank's inventory");
        }

        else {

            System.out.println("the current weight of the inventory for the Tank is: " + calculateYourInventoryWeight());
            System.out.println("Tank cannot carry much more than " + getStrength() + " as total value." );
        }

    }

    public void wield() {

        Scanner scanner = new Scanner(System.in);

        listInventory();

        System.out.println("Please choose the item via numbers");
        int decision = scanner.nextInt();
        int index = decision -1;


        addItemToInventory(getItemHoldingOnHand());
        System.out.println(getItemHoldingOnHand().getName() + " which you hold before is added Tank's inventory.");

        setItemHoldingOnHand(getInventory().get(index));
        System.out.println(getInventory().get(index).getName() + " is wielded now");

        getInventory().remove(index);
    }

}
