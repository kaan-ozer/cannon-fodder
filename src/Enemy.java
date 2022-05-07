import java.security.SecureRandom;

public class Enemy extends  Character{

    //constructor for Enemy
    /*public Enemy(SecureRandom randomNumber) {
        super(randomNumber);
        setHp(calculateHp());
    }
    */


    //it will show the information of the Enemy
    public void showInfos() {
        System.out.println("Character's type is Enemy...");
        System.out.println("Enemy's strength is: " + getStrength());
        System.out.println("Enemy's intelligence is: " + getIntelligence());
        System.out.println("Enemy's vitality is: " + getVitality());
        System.out.println("Enemy's hp is: " + getHp());
    }
}
