import java.util.ArrayList;

public  class Shield extends Weapon implements IWeaponDamage,IWeaponSkills {

    public Shield(String name,int weight,double value){

        super(name, weight, value);
    }

    public double calculateDefence(Character character){
      double defence=getValue() * character.getVitality();
      return defence;
    }

    public void defence(Character chosenEnemy,Character chosenCharacter){
        System.out.println( chosenCharacter.getRace() + " is defencing....");
        System.out.println( chosenCharacter.getRace() + " defenced " + calculateDefence(chosenCharacter) + " damages from the " + chosenEnemy.getRace());



    }

    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getVitality(); //shield damage will be calculated based on vitality
        return attackDamage;
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

    public void SpecialAction(Character chosenEnemy, ArrayList<Character> characters) {

    }

}