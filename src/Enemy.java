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
        int number = Main.randomNumber.nextInt(101);

        if (number < 80) {
            Sword longSword = new Sword("longSword",2,2);
            setItemHoldingOnHand(longSword);
        }

        else if(number >80 && number < 90) {
            Wand woodenWand=new Wand("woodenWand",1,1.5);
            setItemHoldingOnHand(woodenWand);
        }

        else if(number<80 && number < 90){
            Shield  bucklerShieled=new Shield("bucklerShiled",1,2);
            setItemHoldingOnHand(bucklerShieled);
        }


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
}
