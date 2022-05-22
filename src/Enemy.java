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
        Sword shortSword = new Sword("short sword", 1,1);
        setItemHoldingOnHand(shortSword);

    }

    public static Item dropItem() {

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
        else {
            Wand steelWand=new Wand("steelWand", 2,2.6);
            return steelWand;
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
}
