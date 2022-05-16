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

    public void attack(Enemy chosenEnemy, Character chosenCharacter) {

        System.out.println("You are attacking....");
        System.out.println("you gave " + calculateAttackDamage(chosenCharacter) + "to the enemy");

        chosenEnemy.setHp(chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter));

        if (chosenEnemy.isDoesItLive())
        System.out.println("new hp for the enemy is: " + chosenEnemy.getHp());


    }




}
