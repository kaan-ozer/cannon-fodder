import java.security.SecureRandom;

public class Tank extends Character {

    public Tank(int strength,int vitality,int intelligence){
        super(strength,vitality,intelligence);

        this.setHp(calculateHp(strength,vitality,intelligence));

        setRace("Tank");


        Shield shield = new Shield("shield",1,1);
        addItemToInventory(this,shield);
        setItemHoldingOnHand(shield);

    }
    public void showInfos(){
        System.out.println("Character's type is Tank...");
        System.out.println("Tank's strength is: " + getStrength());
        System.out.println("Tank's intelligence is: " + getIntelligence());
        System.out.println("Tank's vitality is: " + getVitality());
        System.out.println("Tank's hp is: " + getHp());
    }


}
