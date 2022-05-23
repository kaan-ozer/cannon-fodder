import java.security.SecureRandom;

public  class  Fighter extends Character{



    public Fighter(int strength,int vitality,int intelligence) {

        // page 3 of the project instruction (based on table values)
        super(strength,vitality,intelligence);
        //setHP
        this.setHp(calculateHp(strength,vitality,intelligence));
        //SetRace
        setRace("Fighter");

        //character will be born with an item which is given at the beginning
        Sword shortSword = new Sword("short sword", 1,1);
        setItemHoldingOnHand(shortSword);
    }


    //it will show the information of the Fighter
    public void showInfos() {
        System.out.println("Character's type is Fighter...");
        System.out.println("Fighter's strength is: " + getStrength());
        System.out.println("Fighter's intelligence is: " + getIntelligence());
        System.out.println("Fighter's vitality is: " + getVitality());
        System.out.println("Fighter's hp is: " + getHp());
    }



}
