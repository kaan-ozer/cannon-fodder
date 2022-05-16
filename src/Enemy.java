import java.security.SecureRandom;

public class Enemy extends  Character{

    //constructor for Enemy

    public Enemy(int strength,int vitality,int intelligence) {

        // page 3 of the project instruction (based on table values)
        super(strength,vitality,intelligence);
        //setHP
        this.setHp(calculateHp(strength,vitality,intelligence));
        //SetRace
        setRace("enemy");

        //character will be born with an item which is given at the beginning
        Sword shortSword = new Sword("short sword", 2,2);
        addItemToInventory(this,shortSword);
        setItemHoldingOnHand(shortSword);

    }


    //it will show the information of the Enemy
    public void showInfos() {
        System.out.println("Character's type is Enemy...");
        System.out.println("Enemy's strength is: " + getStrength());
        System.out.println("Enemy's intelligence is: " + getIntelligence());
        System.out.println("Enemy's vitality is: " + getVitality());
        System.out.println("Enemy's hp is: " + getHp());
    }
}
