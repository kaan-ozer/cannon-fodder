import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Wand extends Weapon implements IWeaponDamage,IWeaponSkills,ICalculateSpecialPower  {

    public Wand(String name, int weight, double value) {
        super(name, weight, value);
    }


    public int calculateSpecialPower(Character character) {
        SecureRandom random = new SecureRandom();

        int specialPower = (1 + random.nextInt(3)) + Math.round((int)character.getIntelligence()/2);

        return specialPower;
    }


    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getIntelligence();// wand damage will calculate based on intelligence

        return Math.round(attackDamage);
    }


    public void attack(Character chosenEnemy, Character chosenCharacter) {

        System.out.println( chosenCharacter.getRace() + " is attacking....");

        System.out.println( chosenCharacter.getRace() + " gave " + calculateAttackDamage(chosenCharacter) + " damage to the " + chosenEnemy.getRace());

        if (chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter) <= 0) {

            chosenEnemy.setHp(0,0,chosenCharacter.getStrength(),chosenCharacter.getVitality(),chosenCharacter.getIntelligence());
            chosenEnemy.setItAlive(false);

            if (chosenEnemy.isItAlive() == false) {
                Main.point++;
                System.out.println(chosenEnemy.getRace() + " is dead");
            }
        }

        else {

            chosenEnemy.setHp(chosenEnemy.getHp() - (long)calculateAttackDamage(chosenCharacter),0,chosenCharacter.getStrength(),chosenCharacter.getVitality(),chosenCharacter.getIntelligence());
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


        while(true) {
            System.out.println();
            System.out.println(actionMenu);
            System.out.println();
            System.out.println("Choose the character who will be healed: ");

            int decision =0;

            try {
             decision = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Please don't try to crash my program and enter integer :)");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println();
                continue;
            }

            int index = decision-1;

            double healPower =  calculateSpecialPower(chosenCharacter);

            if (characters.get(index).isItAlive() == false) {
                System.out.println();
                System.out.println("------------------------------------------");
                System.out.println("Chosen character is dead, you should choose another character");
                System.out.println("------------------------------------------");
                System.out.println();
                continue;
            }

            else {

                if(characters.get(index).getRace().equals("Healer")) {


                    System.out.println();
                    System.out.println("------------------------------------");
                    System.out.println("healer is healing the herself/himself....");


                    characters.get(1).setHp(healPower + characters.get(1).getHp(),characters.get(1).getArmorOnCharacter().getExtraHp(),0,characters.get(1).getVitality(),characters.get(1).getIntelligence());


                    System.out.println("New hp for the " + characters.get(index).getRace() + " is :" + characters.get(index).getHp());
                    System.out.println("------------------------------------");
                    System.out.println();

                    Main.enemyTurn(enemies,characters,0);
                    break;

                }

                else {

                    System.out.println();

                    System.out.println("------------------------------------");
                    System.out.println("healer is healing the " + characters.get(index).getRace() + " .....");

                    characters.get(index).setHp(healPower + characters.get(index).getHp(),characters.get(index).getArmorOnCharacter().getExtraHp(),characters.get(index).getStrength(),characters.get(index).getVitality(),characters.get(index).getIntelligence());

                    System.out.println("New hp for the " + characters.get(index).getRace() + " is :" + characters.get(index).getHp());
                    System.out.println("------------------------------------");

                    Main.enemyTurn(enemies,characters,0);
                    break;

                }

            }




        }



    }
}