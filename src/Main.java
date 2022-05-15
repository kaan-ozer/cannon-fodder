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

        System.out.println("Fighter created with "
                + " S: " + fighter1.getStrength()
                + ", V:" +  fighter1.getVitality()
                + ", I: " + fighter1.getIntelligence()
                + ". The HP is :" +  fighter1.getHp()
                + ". The sword's of the fighter: " + fighter1.getInventory().get(0).getName());

        System.out.println("healer created with "
                + " S: " + healer1.getStrength()
                + ", V:" +  healer1.getVitality()
                + ", I: " + healer1.getIntelligence()
                + ". The HP is :" +  healer1.getHp());

        System.out.println("tank created with "
                + " S: " + tank1.getStrength()
                + ", V:" +  tank1.getVitality()
                + ", I: " + tank1.getIntelligence()
                + ". The HP is :" +  tank1.getHp());


        return charactersAreAtBeginning;
    }

    public static void DisplayItemsInInventory(Character character) {

        if (character.getInventory().size() == 0) {
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.println("There is no any item which assigned to character right now.");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            return;
        }

        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-17s " , "Item's name");
        //System.out.printf("%-14s " , "");
        //System.out.printf("%-10s " , "");
        System.out.println();


        //System.out.printf("%-17s ", character.getInventory().get(0).getName());
       // System.out.printf("%-14s ", character.getInventory().get(0);
      //  System.out.printf("%-10s ",
      //         );
     //   System.out.println();

        for(int i = 0; i < character.getInventory().size() ; i++) {


                System.out.printf("%d. %-17s ", i+1,character.getInventory().get(i).getName());
               // System.out.printf("%-14s ", );
               // System.out.printf("%-10s ", );
                System.out.println();



        }
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }





    public static void main(String[] args) {


        ArrayList<Character> charactersAreAtBeginning = charactersAreAtBeginning();

        //test for seeing inventory.
        DisplayItemsInInventory(charactersAreAtBeginning.get(0));

        /*
        System.out.println("----------------------------------");
        for(Character character : charactersAreAtBeginning) {
            character.showInfos();
            System.out.println("----------------------------------");
        }
        */


        // I am creating the enemies for level 1

        ArrayList<Enemy> level1enemies = createEnemy(1);

        System.out.println("Welcome to the game....");
        System.out.println();


        System.out.println("You are in level 0....");
        System.out.println("You have to beat " + Math.pow(2.0,0) + " enemy to move on....");








    }

}
