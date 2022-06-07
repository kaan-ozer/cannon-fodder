import java.security.SecureRandom;
import java.util.ArrayList;

public class Sword extends Weapon implements IWeaponDamage,IWeaponSkills,ICalculateSpecialPower {



    public Sword(String name, int weight, double value) {
        super(name,weight,value);


    }


    public int calculateSpecialPower(Character character) {
        SecureRandom random = new SecureRandom();

        int specialPower = (1 + random.nextInt(3)) * (int)character.getStrength();

        return specialPower;
    }

    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getStrength();
        return Math.round(attackDamage);
    }

    //it must be inside of the interface because ve write calculate damage different for each class.
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
    public void SpecialAction(ArrayList<Character> characters, ArrayList<Enemy> enemies, Character chosenCharacter) {

        int throwedEnemies = calculateSpecialPower(chosenCharacter);

        int aliveEnemies = 0;

        for (Enemy enemy : enemies) {

            if(enemy.isItAlive()) {
                aliveEnemies++;
            }
        }

        if (throwedEnemies >= aliveEnemies) {

            System.out.println();
            System.out.println("*****************************");
            System.out.println( chosenCharacter.getRace() + " throwed " + aliveEnemies + " enemies" );
            System.out.println("*****************************");
            System.out.println();

            System.out.println("Enemies doesn't attack for one turn...");

            Main.willEnemiesAttack = false;
            chosenCharacter.setCharacterTired(true);


        }

        else {

            System.out.println();
            System.out.println("*****************************");
            System.out.println( chosenCharacter.getRace() + " throwed " + throwedEnemies + " enemies" );
            System.out.println("*****************************");
            System.out.println();

            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Enemies turn....");
            System.out.println("----------------------------------");
            System.out.println();

            boolean passTheTurn = false;

            for (int i = throwedEnemies-1 ; i < enemies.size(); i++) {

                if (enemies.get(i).isItAlive()) {


                    for (int j = 2; j >= 0; j--) {

                        if (characters.get(j).isItAlive()) {

                            System.out.println("----------------------------------");
                            enemies.get(i).getWeaponHoldingOnHand().attack(characters.get(j), enemies.get(i));
                            System.out.println("----------------------------------");
                            passTheTurn = true;
                            break;
                        }
                    }
                }

                if (passTheTurn)
                    break;
            }
        }



    }


}
