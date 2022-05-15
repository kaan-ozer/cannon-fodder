import java.security.SecureRandom;
import java.util.ArrayList;

public class Main {

    public static SecureRandom randomNumber = new SecureRandom();


    public static ArrayList<Enemy> createEnemy(int level) {
        ArrayList<Enemy> activeEnemies = new ArrayList<>();
        // We are creating enemies according to level via "2'n formula"
        for (int i = 0 ; i < Math.pow(2.0,level) ; i++) {
            Enemy anEnemy = new Enemy(randomNumber);
            //then I added those enemies to an array list to prepare enemies for that level, and it will help me to choose enemies easily.
            activeEnemies.add(anEnemy);
        }
        // I obtained an array which was filled with enemies for a specific level.
        return  activeEnemies;
    }
    public static ArrayList<Character> charactersAreAtBeginning () {

        // I created three characters to start the game
        Fighter fighter1 = new Fighter(randomNumber);
        Healer healer1 = new Healer(randomNumber);
        Tank tank1 = new Tank(randomNumber);

        // I added those characters to an array
        ArrayList<Character> charactersAreAtBeginning = new ArrayList<>();
        charactersAreAtBeginning.add(fighter1);
        charactersAreAtBeginning.add(healer1);
        charactersAreAtBeginning.add(tank1);

        return charactersAreAtBeginning;
    }



    public static void main(String[] args) {

        SecureRandom randomNumber = new SecureRandom();

        ArrayList<Character> charactersAreAtBeginning = charactersAreAtBeginning();


        for(Character character : charactersAreAtBeginning) {
            character.showInfos();
            System.out.println("----------------------------------");
        }

        // I am creating the enemies for level 1

        ArrayList<Enemy> level1enemies = createEnemy(1);






    }

}
