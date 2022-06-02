import java.security.SecureRandom;
import java.util.Scanner;

public class Healer extends Character{

    public Healer(int strength,int vitality,int intelligence){

        super(strength,vitality,intelligence);

        Wand woodWand= new Wand("wood wand",1,0.7);
        setWeaponHoldingOnHand(woodWand);

        Armor lightArmor = new Armor("Light Armor", 1, 1);
        setArmorOnCharacter(lightArmor);

        this.setHp(calculateHp(strength,vitality,intelligence)  , getArmorOnCharacter().getExtraHp(),strength,vitality,intelligence);
        setRace("Healer");



    }

    public void showInfos(){
        System.out.println("Character's type is Healer...");
        System.out.println("Healer's strength is: " + getStrength());
        System.out.println("Healer's intelligence is: " + getIntelligence());
        System.out.println("Healer's vitality is: " + getVitality());
        System.out.println("Healer's hp is: " + getHp());
    }

    public  void listInventory() {

        if (getInventory().size() == 0) {
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.println("There is no any item which assigned to Healer right now.");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            return;
        }


        System.out.println();
        System.out.println("Healer wields " + getWeaponHoldingOnHand() + ",  wears " + getArmorOnCharacter());
        System.out.println();

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
            System.out.println(item.getName() + " has been added to Healer's inventory");
        }

        else {

            System.out.println("the current weight of the inventory for the Healer is: " + calculateYourInventoryWeight());
            System.out.println("Healer cannot carry much more than " + getStrength() + " as total value." );
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
            System.out.println(getWeaponHoldingOnHand().getName() + " which you hold before is added Healer's inventory.");

            setWeaponHoldingOnHand((Weapon) (getInventory().get(index)));
            System.out.println(getInventory().get(index).getName() + " is wielded now");

            getInventory().remove(index);

        }

        else if(getInventory().get(index) instanceof Armor) {

            addItemToInventory(getArmorOnCharacter());
            System.out.println(getArmorOnCharacter().getName() + " which you hold before is added Healer's inventory.");

            setArmorOnCharacter((Armor)(getInventory().get(index)));
            System.out.println(getInventory().get(index).getName() + " is wearing now");

            getInventory().remove(index);

        }
    }




}
