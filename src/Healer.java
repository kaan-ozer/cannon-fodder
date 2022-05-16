import java.security.SecureRandom;

public class Healer extends Character{

    public Healer(int strength,int vitality,int intelligence){
        super(strength,vitality,intelligence);

        this.setHp(calculateHp(strength,vitality,intelligence));
        setRace("Healer");

        Wand boneWand = new Wand("bone wand",3,2);
        addItemToInventory(this,boneWand);
        setItemHoldingOnHand(boneWand);
        /*
        Wand woodWand= new Wand("wood wand",2,1);
        addItemToInventory(this,woodWand);

        //setItemHoldingOnHand(woodWand);
        */

    }
    public void showInfos(){
        System.out.println("Character's type is Healer...");
        System.out.println("Healer's strength is: " + getStrength());
        System.out.println("Healer's intelligence is: " + getIntelligence());
        System.out.println("Healer's vitality is: " + getVitality());
        System.out.println("Healer's hp is: " + getHp());
    }



}
