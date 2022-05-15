import java.security.SecureRandom;
import java.util.ArrayList;

public class Main {

    public ArrayList<Enemy> createEnemy(int level,SecureRandom randomNumber) {
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

    public static void main(String[] args) {

        SecureRandom randomNumber = new SecureRandom();

       Fighter fighter1 = new Fighter(randomNumber);
       Healer healer1 = new Healer(randomNumber);
       Tank tank1 = new Tank(randomNumber);

        ArrayList<Character> characters = new ArrayList<>();
        characters.add(fighter1);
        characters.add(healer1);
        characters.add(tank1);

        for(Character character : characters) {
            character.showInfos();
            System.out.println("----------------------------------");
        }






    }

}
