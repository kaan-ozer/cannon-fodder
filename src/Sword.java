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

    public void attack(Character chosenEnemy, Character chosenCharacter) {

        System.out.println( chosenCharacter.getRace() + " is attacking....");
        System.out.println( chosenCharacter.getRace() + " gave " + calculateAttackDamage(chosenCharacter) + " damage to the " + chosenEnemy.getRace());

        if (chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter) <= 0) {

            chosenEnemy.setHp(0);
            chosenEnemy.setItAlive(false);
            System.out.println(chosenEnemy.getRace() + " is dead");
        }

        else {
            chosenEnemy.setHp(chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter));
        }



        if (chosenEnemy.isItAlive()) {  //why we wrote it here?
            System.out.println("new hp for the " + chosenEnemy.getRace() + " is: " + chosenEnemy.getHp());
        }

    }




}
