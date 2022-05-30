import java.util.ArrayList;
import java.util.Scanner;
public class Wand extends Weapon implements IWeaponDamage,IWeaponSkills  {

    public Wand(String name, int weight, double value) {
        super(name, weight, value);
    }


    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getIntelligence();// wand damage will calculate based on intelligence

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

    @Override
    public void SpecialAction(ArrayList<Character> characters, ArrayList<Enemy> enemies,Character chosenCharacter) {

        Scanner scanner = new Scanner(System.in);

        String actionMenu = "-----CharacterList----- \n"
                + "1.Fighter\n"
                + "2.Healer\n"
                + "3.Tank";


        System.out.println();
        System.out.println(actionMenu);
        System.out.println();
        System.out.println("Choose the character who will be healed: ");

        int decision = scanner.nextInt();
        int index = decision-1;

        double healPower =  getValue() * characters.get(1).getIntelligence();

        System.out.println(healPower);
        System.out.println(getValue());
        System.out.println(characters.get(1).getIntelligence());

        if(characters.get(index).getRace().equals("Healer")) {


            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("healer is healing the herself/himself....");

            characters.get(1).setHp(healPower,characters.get(1).getStrength(),characters.get(1).getVitality(),characters.get(1).getIntelligence());

            System.out.println("New hp for the " + characters.get(index).getRace() + " is :" + characters.get(index).getHp());
            System.out.println("------------------------------------");
            System.out.println();

            Main.enemyTurn(enemies,characters,0);

        }

        else {

            System.out.println();

            System.out.println("------------------------------------");
            System.out.println("healer is healing the " + characters.get(index).getRace() + " .....");

            characters.get(index).setHp(healPower,characters.get(index).getStrength(),characters.get(index).getVitality(),characters.get(index).getIntelligence());

            System.out.println("New hp for the " + characters.get(index).getRace() + " is :" + characters.get(index).getHp());
            System.out.println("------------------------------------");

            Main.enemyTurn(enemies,characters,0);

        }




    }
}