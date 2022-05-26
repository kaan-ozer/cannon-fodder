import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static SecureRandom randomNumber = new SecureRandom();
    public static Scanner scanner = new Scanner(System.in);


    public static ArrayList<Enemy> createEnemy(int level) {

        //str must be between 1-5 for the Enemy
        int strength = 1 + randomNumber.nextInt(5);
        //vitality must be between 1-5 for the Enemy
        int vitality = 1 + randomNumber.nextInt(5);
        //intelligence must be between 1-5 for the fighter
        int intelligence = 1 + randomNumber.nextInt(5);

        ArrayList<Enemy> activeEnemies = new ArrayList<>();

        // We are creating enemies according to level via "2'n formula"
        for (int i = 0; i < Math.pow(2.0, level); i++) {
            Enemy anEnemy = new Enemy(strength, vitality, intelligence);
            //then I added those enemies to an array list to prepare enemies for that level, and it will help me to choose enemies easily.
            activeEnemies.add(anEnemy);
        }
        // I obtained an array which was filled with enemies for a specific level.
        return activeEnemies;
    }

    public static ArrayList<Character> creatCharacters() {
        SecureRandom randomNumber = new SecureRandom();

        //abilities for fighter
        int strengthForFighter = 6 + randomNumber.nextInt(5);
        int vitalityForFighter = 3 + randomNumber.nextInt(5);
        int intelligenceForFighter = 1 + randomNumber.nextInt(5);

        //abilities for Healer
        int strengthForHealer = 3 + randomNumber.nextInt(5);
        int vitalityForHealer = 1 + randomNumber.nextInt(5);
        int intelligenceForHealer = 6 + randomNumber.nextInt(5);

        //abilities for Tank
        int strengthForTank = 1 + randomNumber.nextInt(5);
        int vitalityForTank = 6 + randomNumber.nextInt(5);
        int intelligenceForTank = 3 + randomNumber.nextInt(5);


        // I created the fighter character to start the game
        Fighter fighter = new Fighter(strengthForFighter, vitalityForFighter, intelligenceForFighter);
        Healer healer = new Healer(strengthForHealer, vitalityForHealer, intelligenceForHealer);
        Tank tank = new Tank(strengthForTank, vitalityForTank, intelligenceForTank);

        //Tank tank1 = new Tank(randomNumber);

        // I added those characters to an array
        ArrayList<Character> charactersAreAtBeginning = new ArrayList<>();
        charactersAreAtBeginning.add(fighter);
        charactersAreAtBeginning.add(healer);
        charactersAreAtBeginning.add(tank);


        System.out.println("Fighter created with "
                + " S: " + fighter.getStrength()
                + ", V:" + fighter.getVitality()
                + ", I: " + fighter.getIntelligence()
                + ". The HP is :" + fighter.getHp()
                + ". The weapon of the fighter is: " + fighter.getItemHoldingOnHand().getName());

        System.out.println("healer created with "
                + " S: " + healer.getStrength()
                + ", V:" + healer.getVitality()
                + ", I: " + healer.getIntelligence()
                + ". The HP is :" + healer.getHp()
                + ". The weapon of the healer is: " + healer.getItemHoldingOnHand().getName());

        System.out.println("tank created with "
                + " S: " + tank.getStrength()
                + ", V:" + tank.getVitality()
                + ", I: " + tank.getIntelligence()
                + ". The HP is :" + tank.getHp()
                + ". The weapon of the healer is: " + "in progress ");


        return charactersAreAtBeginning;
    }

    public static void showAllEnemies(ArrayList<Enemy> enemies) {


        if (isThereAnyEnemy(enemies) == false) {
            System.out.println("There is no enemy around");
        } else {
            System.out.println();
            System.out.println("--------------------------------------------------------");
            System.out.printf("%-17s ", "Enemy List:");
            System.out.println();


            for (int i = 0; i < enemies.size(); i++) {

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

    public static void showAllDroppedItems(ArrayList<Item> droppedItems) {


        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-17s ", "DroppedItems List:");
        System.out.println();


        for (int i = 0; i < droppedItems.size(); i++) {


            System.out.printf("%d. %-17s ", i + 1, droppedItems.get(i).getName() + (i + 1));
            // System.out.printf("%-14s ", );
            // System.out.printf("%-10s ", );
            System.out.println();

        }

        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public static boolean isThereAnyEnemy(ArrayList<Enemy> enemies) {

        boolean isThereAnyEnemy = false;

        for (int i = 0; i < enemies.size(); i++) {

            if (enemies.get(i).isItAlive() == true) {

                isThereAnyEnemy = true;

            }
        }

        return isThereAnyEnemy;

    }

    public static boolean isThereAnyCharacter(ArrayList<Character> characters) {

        boolean isThereAnyEnemy = false;   //name better to be isThereAnyCharacter

        for (int i = 0; i < characters.size(); i++) {

            if (characters.get(i).isItAlive() == true) {

                isThereAnyEnemy = true;

            }
        }

        return isThereAnyEnemy;

    }

    public static void gameTable(ArrayList<Character> characters, ArrayList<Enemy> enemies) throws InterruptedException {
        // we send two array when we called that method. -k
        //first array for characters and other array is for enemies. -k
        //at the beginning, we send the index of the character which we want to play it. -k


        // I created an array to gather and keep until the end of the level. -k
        ArrayList<Item> droppedItems = new ArrayList<>();

        // this loop will continue until you don't have any alive character. -k
        while (isThereAnyCharacter(characters)) {

            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Your turn....");
            System.out.println("----------------------------------");
            System.out.println();


            // you should choose a character
            int characterIndex = characterMenu(characters);


            while (true) {

                String menu2 = "Choose the process: \n"
                        + "1. Normal Attack\n"
                        + "2. Special Attack(in progress)\n"
                        + "3. See Your İnventory\n"
                        + "4. Wield item from your inventory\n";

                System.out.println(menu2);
                System.out.println("Please choose the process:");
                int process = scanner.nextInt();
                System.out.println();

                int particularEnemyTableIndex=0; ///I put it outside of if  because  I need it fpr special action body

                if (process == 1) {

                    showAllEnemies(enemies);
                    System.out.println("Please choose the enemy which you want to attack:");
                     particularEnemyTableIndex = scanner.nextInt();
                    System.out.println();


                    // you choose the enemy's index from table but in the background arrays start from 0 that is why I decrease 1 to obtain real index. -k
                    int index = particularEnemyTableIndex - 1;
                    //we need try catch here to catch the boundOfexception


                    // you are attacking that enemy. - k
                    System.out.println("----------------------------------");
                    characters.get(characterIndex).getItemHoldingOnHand().attack(enemies.get(index), characters.get(characterIndex));
                    System.out.println("----------------------------------");
                    Thread.sleep(1500);

                    // if the enemy dies an item will drop and I added that item to the droppedItems arraylist to reach them at the end of the level. -k
                    if (enemies.get(index).isItAlive() == false) {
                        Item droppedItem = enemies.get(index).dropItem();

                        if (droppedItem != null) {
                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println(droppedItem.getName() + " has dropped" + "by " + enemies.get(index).getRace());
                            System.out.println("*********************************");
                            System.out.println();

                            droppedItems.add(droppedItem);
                        } else {
                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println("nothing has dropped" + "by " + enemies.get(index).getRace());
                            System.out.println("*********************************");
                            System.out.println();
                        }

                    }

                    //unless there is enemy, I can collect the ıtems.
                    if (isThereAnyEnemy(enemies) == false) {

                        Thread.sleep(2000);
                        System.out.println();
                        System.out.println("----------------------------------");
                        System.out.println("there is no enemy anymore");
                        System.out.println("----------------------------------");


                        String menu3 = "Choose the process: \n\n"
                                + "---Dropped Items---\n"
                                + "1. Pick and Examine\n"
                                + "2. Wield \n"
                                + "3. Pick and Add Your Inventory\n\n"
                                + "---Inventory Items---\n"
                                + "4. Pick and Wield \n"
                                + "5. List Inventory\n"
                                + "6. Drop Item From Your Inventory \n"
                                + "7. Next \n";


                        while (true) {
                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println(menu3);
                            System.out.println("*********************************");
                            System.out.println();

                            int input = scanner.nextInt();

                            if(input == 1) {

                                //it'll print out the all items on the ground - k
                                showAllDroppedItems(droppedItems);

                                // I choose the item from the table
                                System.out.println("Please pick the item ");
                                int particularItemTableIndex = scanner.nextInt();
                                System.out.println();

                                int itemIndex = particularItemTableIndex - 1;



                                droppedItems.get(itemIndex).printItemInfo();

                            }
                            else if(input == 2) {
                                //it'll print out the all items on the ground - k
                                showAllDroppedItems(droppedItems);

                                // I choose the item from the table
                                System.out.println("Please choose the item ");
                                int particularItemTableIndex = scanner.nextInt();
                                System.out.println();

                                int itemIndex = particularItemTableIndex - 1;


                                // if there is a problem to add your holding item to your inventory due to weight
                                // there is a bug when you choose twice the 3 option
                                // this method 'll develop
                                if (droppedItems.get(itemIndex).isItTaken == false) {
                                    System.out.println("item which you hold has been changed.");
                                    characters.get(characterIndex).addItemToInventory(characters.get(characterIndex), characters.get(characterIndex).getItemHoldingOnHand());
                                    characters.get(characterIndex).setItemHoldingOnHand(droppedItems.get(itemIndex));
                                    droppedItems.get(itemIndex).isItTaken = true;
                                } else if (droppedItems.get(itemIndex).isItTaken == true && characters.get(characterIndex).getItemHoldingOnHand() != droppedItems.get(itemIndex)) {
                                    characters.get(characterIndex).addItemToInventory(characters.get(characterIndex), characters.get(characterIndex).getItemHoldingOnHand());
                                    characters.get(characterIndex).removeItemFromInventory(droppedItems.get(itemIndex));

                                    characters.get(characterIndex).setItemHoldingOnHand(droppedItems.get(itemIndex));

                                } else {

                                    System.out.println("you already get this");
                                }
                            }
                            else if(input == 3) {
                                //it'll print out the all items on the ground - k
                                showAllDroppedItems(droppedItems);

                                // I choose the item from the table
                                System.out.println("Please choose the item ");
                                int particularItemTableIndex = scanner.nextInt();
                                System.out.println();

                                int itemIndex = particularItemTableIndex - 1;

                                if (droppedItems.get(itemIndex).isItTaken == false) {

                                    characters.get(characterIndex).addItemToInventory(characters.get(characterIndex), droppedItems.get(itemIndex));
                                    droppedItems.get(itemIndex).isItTaken = true;
                                } else {

                                    System.out.println("you already got this item");
                                }

                            }
                            else if(input == 4) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {
                                    characters.get(characterIndex).listInventory();

                                    System.out.println("Please pick the item ");
                                    int particularItemTableIndex = scanner.nextInt();
                                    System.out.println();

                                    int itemIndex = particularItemTableIndex - 1;

                                    characters.get(characterIndex).getInventory().add(characters.get(characterIndex).getItemHoldingOnHand());

                                    System.out.println();
                                    System.out.println("----------------------------");
                                    System.out.println(characters.get(characterIndex).getItemHoldingOnHand().getName() + "Added your inventory");
                                    System.out.println("----------------------------");
                                    characters.get(characterIndex).setItemHoldingOnHand(characters.get(characterIndex).getInventory().get(itemIndex));
                                    System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " is wielded");
                                    System.out.println("----------------------------");
                                    System.out.println();


                                } else {
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    System.out.println("There is no item in your inventory");
                                    System.out.println("--------------------------------------");
                                    System.out.println();
                                    continue;
                                }

                            }
                            else if(input == 5) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {
                                    characters.get(characterIndex).listInventory();
                                } else {
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    System.out.println("you don't have any item....");
                                    System.out.println("--------------------------------------");
                                    System.out.println();
                                    continue;
                                }

                            }
                            else if(input == 6) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {
                                    characters.get(characterIndex).listInventory();

                                    System.out.println("Please pick the item ");
                                    int particularItemTableIndex = scanner.nextInt();
                                    System.out.println();

                                    int itemIndex = particularItemTableIndex - 1;

                                    System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " removed from your inventory....");
                                    characters.get(characterIndex).removeItemFromInventory(characters.get(characterIndex).getInventory().get(itemIndex));

                                } else {
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    System.out.println("There is no item in your inventory");
                                    System.out.println("--------------------------------------");
                                    System.out.println();
                                    continue;
                                }


                            }
                            else if(input == 7) {
                                break;
                            }


                        }


                        return;

                    } else {
                        System.out.println();
                        System.out.println("----------------------------------");
                        System.out.println("Enemies turn....");
                        System.out.println("----------------------------------");
                        System.out.println();

                        boolean passTheTurn = false;

                        for (int i = 0; i < enemies.size(); i++) {

                            if (enemies.get(i).isItAlive()) {

                                for (int j = 2; j >= 0; j--) {

                                    if (characters.get(j).isItAlive()) {

                                        System.out.println("----------------------------------");
                                        enemies.get(i).getItemHoldingOnHand().attack(characters.get(j), enemies.get(i));
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


                } else if (process == 2) {

                boolean isActionWithWand=false;
                boolean isActionWithShield=false;
                boolean isActionWithSword=false;


                    if (characters.get(characterIndex).getItemHoldingOnHand().getClass().getName().equals("Wand")){
                        isActionWithWand=true;
                        System.out.println("enter: 1-to heal fighter ,  2-to heal tank ,   3-to heal healer  ");
                        int healChoice=scanner.nextInt();
                        if (healChoice==1){//heal the fighter
                            characters.get(characterIndex).getItemHoldingOnHand().SpecialAction(isActionWithWand,enemies.get(particularEnemyTableIndex),characters.get(characterIndex),characters.get(characterIndex));
                            //<<<<<<<break;
                        }
                        else if (healChoice==2){//heal the tank
                            characters.get(characterIndex).getItemHoldingOnHand().SpecialAction(isActionWithWand,enemies.get(particularEnemyTableIndex),characters.get(characterIndex),characters.get(characterIndex-1));
                        }
                        else if (healChoice==3){//heal the healer //  heal the healer when he dies  should be checked
                            characters.get(characterIndex).getItemHoldingOnHand().SpecialAction(isActionWithWand,enemies.get(particularEnemyTableIndex),characters.get(characterIndex),characters.get(characterIndex));
                        }
                    }
                    else if (characters.get(characterIndex).getItemHoldingOnHand().getClass().getName().equals("Sword")){
                        isActionWithSword=true;
                        characters.get(characterIndex).getItemHoldingOnHand().SpecialAction(isActionWithSword,enemies.get(particularEnemyTableIndex),characters.get(characterIndex),characters.get(characterIndex));

                        break;
                    }
                    else if (characters.get(characterIndex).getItemHoldingOnHand().getClass().getName().equals("Shield")){
                        break;
                    }
                  boolean passTheTurn = false;   //if the special action is for" sword "one turn of enemy and character  should be passed
                    if (isActionWithSword){passTheTurn=true;
                     }

                }




                else if (process == 3) {
                    characters.get(characterIndex).listInventory();
                } else if (process == 4) {

                    if (characters.get(characterIndex).getInventory().size() == 0) {
                        System.out.println("-----------------------------------------");
                        System.out.println("There is no item in your inventory yet");
                        System.out.println("-----------------------------------------");
                    } else {
                        characters.get(characterIndex).wield();
                    }
                } else {
                    System.out.println("invalid number...");

                }


                System.out.println();

            }
        }


    }

    public static int characterMenu(ArrayList<Character> characters) {

        // that method prints out the character menu and it will continue by you choose a character which is alive. -k
        while (true) {
            System.out.println();
            String isFighterAlive = characters.get(0).isItAlive() ? "Alive" : "Dead";
            String isHealerAlive = characters.get(1).isItAlive() ? "Alive" : "Dead";
            String isTankAlive = characters.get(2).isItAlive() ? "Alive" : "Dead";

            String actionMenu = "Choose your character: \n"
                    + "1.Fighter (" + isFighterAlive + ")\n"
                    + "2.Healer (" + isHealerAlive + ")\n"
                    + "3.Tank (" + isTankAlive + ")";

            System.out.println(actionMenu);
            System.out.println();

            System.out.println("Choose the character which you want to play:");
            int characterDecision = scanner.nextInt();
            int characterIndex = characterDecision - 1;

            if (!characters.get(characterIndex).isItAlive()) {
                System.out.println("You cannot choose that character because he is already dead...");
                continue;
            } else {
                System.out.println();
                return characterIndex;
            }

        }
    }

   /* public static boolean wantUseSpecialAction(int userInput) {
        boolean haveSpecialAction = false;

        if (userInput == 1) {
            haveSpecialAction = true;


        } else if (userInput == 0) {
            haveSpecialAction = false;

        }
        return haveSpecialAction;
    }*/

    public static void main(String[] args) throws InterruptedException {

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Welcome to Cannon Fodder game....");
        System.out.println("-------------------------------------");
        System.out.println();

        Thread.sleep(1000);

        int currentLevel = 0;
        ArrayList<Enemy> level1enemies = createEnemy(0);
        ArrayList<Character> characters = creatCharacters();
        System.out.println();


        System.out.println("Creating Level " + currentLevel + ", with " + (int) Math.pow(2.0, currentLevel) + " enemy soldier.");
        System.out.println("Entering Level " + currentLevel + " Fighter enters.");
        System.out.println();

        Thread.sleep(1500);


        while (isThereAnyCharacter(characters)) {

            //we need to check if  the charcter is alive here.unless it will continue to hit even though it is dead.


            gameTable(characters, createEnemy(currentLevel));
            currentLevel++;

            if (isThereAnyCharacter(characters)) {
                System.out.println();
                System.out.println("Next level is starting");
                System.out.println();

            }

        }


    }

}
