import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static SecureRandom randomNumber = new SecureRandom();
    public static Scanner scanner = new Scanner(System.in);


    public static ArrayList<Enemy> createEnemy(int level) {

        //str must be between 1-5 for the Enemy
        int strength = 1+randomNumber.nextInt(5);
        //vitality must be between 1-5 for the Enemy
        int vitality = 1+randomNumber.nextInt(5);
        //intelligence must be between 1-5 for the fighter
        int intelligence = 1+randomNumber.nextInt(5);

        ArrayList<Enemy> activeEnemies = new ArrayList<>();

        // We are creating enemies according to level via "2'n formula"
        for (int i = 0 ; i < Math.pow(2.0,level) ; i++) {
            Enemy anEnemy = new Enemy(strength,vitality,intelligence);
            //then I added those enemies to an array list to prepare enemies for that level, and it will help me to choose enemies easily.
            activeEnemies.add(anEnemy);
        }
        // I obtained an array which was filled with enemies for a specific level.
        return  activeEnemies;
    }
    //done
    public static ArrayList<Character> creatCharacters () {
        SecureRandom randomNumber = new SecureRandom();

        //abilities for fighter
        int strengthForFighter = 6+randomNumber.nextInt(5);
        int vitalityForFighter = 3+randomNumber.nextInt(5);
        int intelligenceForFighter = 1+randomNumber.nextInt(5);

        //abilities for Healer
        int strengthForHealer = 3+randomNumber.nextInt(5);
        int vitalityForHealer = 1+randomNumber.nextInt(5);
        int intelligenceForHealer = 6+randomNumber.nextInt(5);

        //abilities for Tank
        int strengthForTank = 1+randomNumber.nextInt(5);
        int vitalityForTank = 6+randomNumber.nextInt(5);
        int intelligenceForTank = 3+randomNumber.nextInt(5);


        // I created the fighter character to start the game
        Fighter fighter = new Fighter(strengthForFighter,vitalityForFighter,intelligenceForFighter);
        Healer healer = new Healer(strengthForHealer,vitalityForHealer,intelligenceForHealer);
        Tank tank = new Tank(strengthForTank,vitalityForTank,intelligenceForTank);

        //Tank tank1 = new Tank(randomNumber);

        // I added those characters to an array
        ArrayList<Character> charactersAreAtBeginning = new ArrayList<>();
        charactersAreAtBeginning.add(fighter);
        //charactersAreAtBeginning.add(healer1);
        //charactersAreAtBeginning.add(tank1);

        System.out.println("Fighter created with "
                + " S: " + fighter.getStrength()
                + ", V:" +  fighter.getVitality()
                + ", I: " + fighter.getIntelligence()
                + ". The HP is :" +  fighter.getHp()
                + ". The weapon of the fighter is: " + fighter.getItemHoldingOnHand().getName());

       System.out.println("healer created with "
                + " S: " + healer.getStrength()
                + ", V:" +  healer.getVitality()
                + ", I: " + healer.getIntelligence()
                + ". The HP is :" +  healer.getHp()
               + ". The weapon of the healer is: " + healer.getItemHoldingOnHand().getName());

        System.out.println("tank created with "
                + " S: " + tank.getStrength()
                + ", V:" +  tank.getVitality()
                + ", I: " + tank.getIntelligence()
                + ". The HP is :" +  tank.getHp()
                + ". The weapon of the healer is: " + "in progress ");


        return charactersAreAtBeginning;
    }
    public static void showAllEnemies(ArrayList<Enemy> enemies) {


        if (isThereAnyEnemy(enemies) == false) {
            System.out.println("There is no enemy around");
        }

        else{
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.printf("%-17s " , "Enemy List:");
            System.out.println();




            for(int i = 0; i < enemies.size() ; i++) {

                if (enemies.get(i).isItAlive() == true) {


                    System.out.printf("%d. %-17s ", i + 1, enemies.get(i).getRace() + (i + 1));
                    // System.out.printf("%-14s ", );
                    // System.out.printf("%-10s ", );
                    System.out.println();
                }
            }

            System.out.println("--------------------------------------------------------");
            System.out.println();
        }


    }
    public static boolean isThereAnyEnemy(ArrayList<Enemy> enemies) {

        boolean isThereAnyEnemy = false;

        for(int i = 0; i < enemies.size() ; i++) {

            if (enemies.get(i).isItAlive() == true) {

                isThereAnyEnemy = true;

            }
        }

        return isThereAnyEnemy;

    }
    public static boolean isThereAnyCharacter(ArrayList<Character> characters) {

        boolean isThereAnyEnemy = false;

        for(int i = 0; i < characters.size() ; i++) {

            if (characters.get(i).isItAlive() == true) {

                isThereAnyEnemy = true;

            }
        }

        return isThereAnyEnemy;

    }

    public static void gameTable(ArrayList<Character> characters,ArrayList<Enemy> enemies,int characterIndex) {

        while (isThereAnyCharacter(characters)) {

            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Your turn....");
            System.out.println("----------------------------------");

            System.out.println();
            showAllEnemies(enemies);
            System.out.println("Please choose the enemy which you want to attack:");
            int particularEnemyTableIndex = scanner.nextInt();
            System.out.println();


            int index = particularEnemyTableIndex - 1;

            System.out.println("----------------------------------");
            characters.get(characterIndex-1).getItemHoldingOnHand().attack(enemies.get(index), characters.get(characterIndex-1));
            System.out.println("----------------------------------");

            if (isThereAnyEnemy(enemies) == false) {
                System.out.println("there is no enmy anymore");
                System.out.println("----------------------------------");
                return;

            }

            else {
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Enemies turn....");
                System.out.println("----------------------------------");
                System.out.println();

                boolean passTheTurn = false;

                for (int i = 0; i < enemies.size(); i++) {

                    if (enemies.get(i).isItAlive()) {

                        for (int j = 0; j < characters.size(); j++) {

                            if (characters.get(j).isItAlive()) {
                                System.out.println("----------------------------------");
                                enemies.get(i).getItemHoldingOnHand().attack(characters.get(0), enemies.get(j));
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





    public static void main(String[] args) {

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Welcome to Cannon Fodder game....");
        System.out.println("-------------------------------------");
        System.out.println();

        int currentLevel = 0;
        ArrayList<Enemy> level1enemies = createEnemy(0);
        ArrayList<Character> characters = creatCharacters();
        System.out.println();


        System.out.println("Creating Level " + currentLevel + ", with " + (int)Math.pow(2.0,currentLevel)  + " enemy soldier.");
        System.out.println("Entering Level " +  currentLevel +  " Fighter enters.");
        System.out.println();

        System.out.println("---------------");
        System.out.println("It is your turn......");
        System.out.println("---------------");
        System.out.println();

        String actionMenu = "Choose your character: \n"
                + "1.Fighter\n"
                + "2.Tank\n"
                + "3.Healer";
        System.out.println(actionMenu);
        System.out.println();


        System.out.println("Choose the character which you want to play:");
        int characterDecision = scanner.nextInt();
        System.out.println();

        if (characterDecision == 1) {

            System.out.println("Fighter has been chosen...");


           while(isThereAnyCharacter(characters)) {
               gameTable(characters, createEnemy(currentLevel),characterDecision);
               currentLevel++;

               if(isThereAnyCharacter(characters)) {
                   System.out.println();
                   System.out.println("Next level is starting");
                   System.out.println();

               }

           }

        }

        else if(characterDecision == 2) {
            System.out.println("in progress...");
        }

        else if(characterDecision == 3) {
            System.out.println("in progress...");
        }

        else{
            System.out.println("you entered an invalid number...");
        }

















    }

}
