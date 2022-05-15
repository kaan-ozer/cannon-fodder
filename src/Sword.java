import java.util.ArrayList;

public class Sword extends Item implements Actions{


    public Sword(String name, int weight,
             double value) {
        super(name,weight,value);
    }

    public double calculateAttackDamage(Character character) {
        double attackDamage = getValue() * character.getStrength();

        return attackDamage;
    }

    public void attack(ArrayList<Enemy> enemies, ArrayList<Character> characters) {

    }


}
