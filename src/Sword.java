import java.util.ArrayList;

public  class Sword extends Item {


    public Sword(String name, int weight,
             double value) {
        super(name,weight,value);
    }


    // kaan 'll handle it
    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getStrength();
        return attackDamage;
    }

    @Override
    public void SpecialAction(boolean isSpecialActionWithSword,Character chosenEnemy, Character chosenCharacter,Character C) {//I will fix it just there should be  one more parameter
        System.out.println("special action activated !" + chosenCharacter.getRace() + "to keep " + chosenEnemy.getRace() + " away for one turn");
        System.out.println(chosenCharacter.getRace()+"can not cause dame for few turns...");

    }

    public void attack(Character chosenEnemy, Character chosenCharacter) {

        System.out.println( chosenCharacter.getRace() + " is attacking....");
        System.out.println( chosenCharacter.getRace() + " gave " + calculateAttackDamage(chosenCharacter) + " damage to the " + chosenEnemy.getRace());

        if (chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter) <= 0) {

            chosenEnemy.setHp(0,chosenCharacter.getStrength(),chosenCharacter.getVitality(),chosenCharacter.getIntelligence());
            chosenEnemy.setItAlive(false);
            System.out.println(chosenEnemy.getRace() + " is dead");

        }

        else {
            chosenEnemy.setHp(chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter),chosenCharacter.getStrength(),chosenCharacter.getVitality(),chosenCharacter.getIntelligence());
        }



        if (chosenEnemy.isItAlive()) {  //why we wrote it here? - we checked if enemy is alive or not
            //if enemy is alive, we will prin out the new hp value after the enemy got damage by character
            System.out.println("new hp for the " + chosenEnemy.getRace() + " is: " + chosenEnemy.getHp());
        }

    }




}
