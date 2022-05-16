import java.util.ArrayList;

public class Sword extends Item {


    public Sword(String name, int weight,
             double value) {
        super(name,weight,value);
    }

    // kaan 'll handle it
    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getStrength();
        return attackDamage;
    }

    public void attack(Enemy chosenEnemy, Character chosenCharacter) {

        System.out.println("You are attacking....");
        System.out.println("you gave " + calculateAttackDamage(chosenCharacter) + " damage to the enemy");

        if (chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter) < 0) {
            chosenEnemy.setHp(chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter));
            System.out.println("Enemy is dead");
            chosenEnemy.setHp(0);
            chosenEnemy.setItAlive(false);
        }
        else {
            chosenEnemy.setHp(chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter));
        }



        if (chosenEnemy.isItAlive()) {
            System.out.println("new hp for the enemy is: " + chosenEnemy.getHp());
        }

    }




}
