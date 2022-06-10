import javax.xml.stream.events.Characters;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean willEnemiesAttack = true;
    public static int point = 0;

    public static ArrayList<Enemy> createEnemy(int level) {

        SecureRandom randomNumber = new SecureRandom();


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
                + ", HP: " + fighter.getHp()
                + ". Attack Power: " + Math.round(fighter.getWeaponHoldingOnHand().getValue() * fighter.getStrength())
                + ". Wears: " + fighter.getArmorOnCharacter().getName()
                + ". Wears: " + fighter.getArmorOnCharacter().getName());

        System.out.println("healer created with "
                + " S: " + healer.getStrength()
                + ", V:" + healer.getVitality()
                + ", I: " + healer.getIntelligence()
                + ", HP: " + healer.getHp()
                + ". Attack Power: " + Math.round(healer.getWeaponHoldingOnHand().getValue() * healer.getIntelligence())
                + ". Wields: " + healer.getWeaponHoldingOnHand().getName()
                + ". Wears: " + healer.getArmorOnCharacter().getName());

        System.out.println("tank created with "
                + " S: " + tank.getStrength()
                + ", V:" + tank.getVitality()
                + ", I: " + tank.getIntelligence()
                + ", HP: " + tank.getHp()
                + ". Attack Power: " + Math.round(tank.getWeaponHoldingOnHand().getValue() * tank.getVitality())
                + ". Wields: " + tank.getWeaponHoldingOnHand().getName()
                + ". Wears: " + tank.getArmorOnCharacter().getName());


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
                     System.out.printf("%-10s ", "its hp:" + enemies.get(i).getHp());
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
    public static void enemyTurn(ArrayList<Enemy> enemies, ArrayList<Character> characters, int order) {

        if (willEnemiesAttack == true) {
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Enemies turn....");
            System.out.println("----------------------------------");
            System.out.println();

            boolean passTheTurn = false;

            for (int i = order; i < enemies.size(); i++) {

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
        } else {
            willEnemiesAttack = true;
        }

    }
    public static void showAllDroppedItems(ArrayList<Item> droppedItems) {


        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-17s ", "DroppedItems List:");
        System.out.println();


        for (int i = 0; i < droppedItems.size(); i++) {


            System.out.printf("%d. %-17s ", i + 1, droppedItems.get(i).getName());
            // System.out.printf("%-droppedItems
            // System.out.printf("%-10s ", );
            System.out.println();

        }

        System.out.println("--------------------------------------------------------");
        System.out.println();
    }






    public static void gameTable(ArrayList<Character> characters, ArrayList<Enemy> enemies) throws InterruptedException {
        // we send two array when we called that method. -k
        //first array for characters and other array is for enemies. -k
        //at the beginning, we send the index of the character which we want to play it. -k


        // I created an array to gather and keep until the end of the level. -k
        ArrayList<Item> droppedItems = new ArrayList<>();

        // this loop will continue until you don't have any alive character. -k
        while (isThereAnyCharacter(characters)) {


            int characterIndex = 0;
            // you should choose a character
            try {
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Your turn....");
                System.out.println("----------------------------------");
                System.out.println();

                characterIndex = characterMenu(characters);
            } catch (IndexOutOfBoundsException e) {
                System.out.println();
                System.out.println("*******************");
                System.out.println("You entered invalid value....");
                System.out.println("*******************");
                System.out.println();
                System.out.println("-------------------------");
                System.out.println("You have to choose it again....");
                System.out.println("-------------------------");
                continue;
            }


            while (true) {

                String menu2 = "Choose the process: \n"
                        + "1. Normal Attack\n"
                        + "2. Special Attack\n"
                        + "3. See Your İnventory\n"
                        + "4. Wield / Wear item from your inventory\n"
                        + "5. Drop item from your inventory";

                System.out.println("----------------------------------------");
                System.out.println(menu2);
                System.out.println("----------------------------------------");

                int process = 0;
                try {
                    System.out.println("Please choose the process:");
                     process = scanner.nextInt();
                    System.out.println();
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

                int particularEnemyTableIndex = 0; ///I put it outside of if  because  I need it fpr special action body

                int currentActiveCharacters = 0;

                int index = 0;


                if (process == 1) {


                    //if last alive character is tired, one turn will pass without any action.
                    for (Character character : characters) {

                        if (character.isItAlive()) {
                            currentActiveCharacters++;
                        }
                    }

                    //if your last character is tired, one turn will pass without being any aciton
                    if (currentActiveCharacters == 1 && characters.get(characterIndex).isCharacterTired() == true) {
                        System.out.println("One turn passed without any action because " + characters.get(characterIndex).getRace() + " was tired.");
                        characters.get(characterIndex).setCharacterTired(false);
                        break;
                    }


                    currentActiveCharacters = 0;

                    //your character must rest after used its ability
                    if (characters.get(characterIndex).isCharacterTired() == true) {
                        System.out.println(characters.get(characterIndex).getRace() + "is tired. Therefore," + " cannot be used for one turn...");
                        break;
                    }

                    for (Character character : characters) {
                        character.setCharacterTired(false);
                    }



                    while(true) {

                        showAllEnemies(enemies);


                            try {
                                try {
                                    System.out.println("Please choose the enemy which you want to attack:");
                                    particularEnemyTableIndex = scanner.nextInt();
                                    System.out.println();
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


                                // you choose the enemy's index from table but in the background arrays start from 0 that is why I decrease 1 to obtain real index. -k
                                index = particularEnemyTableIndex - 1;
                                //we need try catch here to catch the boundOfexception

                                if(enemies.get(index).isItAlive() == false) {
                                    System.out.println("there is nobody there...");
                                    continue;
                                }


                                // you are attacking that enemy. - k
                                System.out.println("----------------------------------");
                                characters.get(characterIndex).getWeaponHoldingOnHand().attack(enemies.get(index), characters.get(characterIndex));
                                System.out.println("----------------------------------");
                                break;

                            }
                            catch (IndexOutOfBoundsException e) {
                                System.out.println("you entered an invalid value");
                                System.out.println();
                                continue;
                            }
                    }


                    System.out.println("Your point is currently : " + point);
                    Thread.sleep(1500);

                    // if the enemy dies an item will drop and I added that item to the droppedItems arraylist to reach them at the end of the level. -k
                    if (enemies.get(index).isItAlive() == false) {

                        Item droppedItem = enemies.get(index).itemDrop();

                        if (droppedItem != null) {

                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println(droppedItem.getName() + " has dropped" + "by " + enemies.get(index).getRace());
                            System.out.println("*********************************");
                            System.out.println();

                            droppedItems.add(droppedItem);
                        }

                        else {

                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println(enemies.get(index).getRace() + " drops nothing...");
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
                                + "2. Wield / Wear \n"
                                + "3. Pick and Add Your Inventory\n\n"
                                + "---Inventory Items---\n"
                                + "4. Pick and Wield / Wear \n"
                                + "5. List Inventory\n"
                                + "6. Drop Item From Your Inventory \n\n"
                                + "---Next Level--- \n"
                                + "7. Next \n";


                        while (true) {

                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println(menu3);
                            System.out.println("*********************************");
                            System.out.println();
                            int input = 0;

                            try {
                                System.out.println("Please choose the process:");
                                 input = scanner.nextInt();
                                System.out.println();
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


                            boolean isThereAnyItem = false;

                            for (Item item : droppedItems) {

                                if (item != null) {
                                    isThereAnyItem = true;
                                }

                            }


                            if (input == 1) {

                                if (isThereAnyItem == false) {
                                    System.out.println();
                                    System.out.println("-------------------------");
                                    System.out.println("There is no item to take");
                                    System.out.println("-------------------------");
                                    System.out.println();
                                    continue;
                                }



                                int particularItemTableIndex = 0;

                             while(true) {


                                 //it'll print out the all items on the ground - k
                                 showAllDroppedItems(droppedItems);

                                 // I choose the item from the table

                                 try {
                                     System.out.println("Please pick the item ");
                                     particularItemTableIndex = scanner.nextInt();
                                     System.out.println();
                                     break;
                                 } catch (InputMismatchException e) {
                                     scanner.nextLine();
                                     System.out.println();
                                     System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                     System.out.println("Please don't try to crash my program and enter integer :)");
                                     System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                     System.out.println();
                                     continue;
                                 }
                             }

                                int itemIndex = particularItemTableIndex - 1;

                                droppedItems.get(itemIndex).printItemInfo();


                                if (droppedItems.get(itemIndex) instanceof Sword) {
                                    System.out.print(" Attack Damage: " + droppedItems.get(itemIndex).getValue() * characters.get(characterIndex).getStrength());
                                }
                                if (droppedItems.get(itemIndex) instanceof Wand){
                                    System.out.print(" Attack Damage: " + droppedItems.get(itemIndex).getValue() * characters.get(characterIndex).getIntelligence());
                                }
                                if(droppedItems.get(itemIndex) instanceof Shield) {
                                    System.out.print(" Attack Damage: " + droppedItems.get(itemIndex).getValue() * characters.get(characterIndex).getVitality());
                                }
                                if(droppedItems.get(itemIndex) instanceof Armor) {
                                    System.out.print(" Extra hp:  " + ((Armor) droppedItems.get(itemIndex)).getExtraHp());
                                }

                                System.out.println();



                            }
                            else if (input == 2) {

                                if (isThereAnyItem == false) {
                                    System.out.println();
                                    System.out.println("-------------------------");
                                    System.out.println("There is no item to take");
                                    System.out.println("-------------------------");
                                    System.out.println();
                                    continue;
                                }


                                int particularItemTableIndex = 0;

                                while(true) {


                                    //it'll print out the all items on the ground - k
                                    showAllDroppedItems(droppedItems);

                                    // I choose the item from the table

                                    try {
                                        System.out.println("Please choose the item ");
                                        particularItemTableIndex = scanner.nextInt();
                                        System.out.println();
                                        break;
                                    } catch (InputMismatchException e) {
                                        scanner.nextLine();
                                        System.out.println();
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println("Please don't try to crash my program and enter integer :)");
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println();
                                        continue;
                                    }
                                }

                                int itemIndex = particularItemTableIndex - 1;

                                if(droppedItems.get(itemIndex) instanceof Weapon) {
                                    // if there is a problem to add your holding item to your inventory due to weight
                                    // there is a bug when you choose twice the 3 option
                                    // this method 'll develop
                                    if (droppedItems.get(itemIndex).isItTaken == false) {
                                        System.out.println("item which you hold has been changed.");
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getWeaponHoldingOnHand());
                                        characters.get(characterIndex).setWeaponHoldingOnHand((Weapon) droppedItems.get(itemIndex));
                                        droppedItems.get(itemIndex).isItTaken = true;
                                    } else if (droppedItems.get(itemIndex).isItTaken == true && characters.get(characterIndex).getWeaponHoldingOnHand() != droppedItems.get(itemIndex)) {
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getWeaponHoldingOnHand());
                                        characters.get(characterIndex).removeItemFromInventory(droppedItems.get(itemIndex));

                                        characters.get(characterIndex).setWeaponHoldingOnHand((Weapon) droppedItems.get(itemIndex));

                                    }

                                    else {

                                        System.out.println("you already get this");
                                    }
                                }

                                if(droppedItems.get(itemIndex) instanceof Armor) {
                                    // if there is a problem to add your holding item to your inventory due to weight
                                    // there is a bug when you choose twice the 3 option
                                    // this method 'll develop
                                    if (droppedItems.get(itemIndex).isItTaken == false) {
                                        System.out.println("item which you wear has been changed.");
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getArmorOnCharacter());
                                        characters.get(characterIndex).setArmorOnCharacter((Armor) droppedItems.get(itemIndex));
                                        droppedItems.get(itemIndex).isItTaken = true;
                                    } else if (droppedItems.get(itemIndex).isItTaken == true && characters.get(characterIndex).getWeaponHoldingOnHand() != droppedItems.get(itemIndex)) {
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getArmorOnCharacter());
                                        characters.get(characterIndex).removeItemFromInventory(droppedItems.get(itemIndex));

                                        characters.get(characterIndex).setArmorOnCharacter((Armor) droppedItems.get(itemIndex));

                                    }

                                    else {

                                        System.out.println("you already get this");
                                    }
                                }

                            }
                            else if (input == 3) {

                                if (isThereAnyItem == false) {
                                    System.out.println();
                                    System.out.println("-------------------------");
                                    System.out.println("There is no item to take");
                                    System.out.println("-------------------------");
                                    System.out.println();
                                    continue;
                                }


                                int particularItemTableIndex = 0;

                                while(true) {


                                    //it'll print out the all items on the ground - k
                                    showAllDroppedItems(droppedItems);

                                    // I choose the item from the table

                                    try {
                                        System.out.println("Please choose the item ");
                                        particularItemTableIndex = scanner.nextInt();
                                        System.out.println();
                                        break;
                                    } catch (InputMismatchException e) {
                                        scanner.nextLine();
                                        System.out.println();
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println("Please don't try to crash my program and enter integer :)");
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println();
                                        continue;
                                    }
                                }
                                int itemIndex = particularItemTableIndex - 1;

                                if (droppedItems.get(itemIndex).isItTaken == false) {

                                    characters.get(characterIndex).addItemToInventory(droppedItems.get(itemIndex));
                                    droppedItems.get(itemIndex).isItTaken = true;
                                }
                                else {

                                    System.out.println("you already got this item");
                                }

                            }
                            else if (input == 4) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {

                                    int particularItemTableIndex = 0;

                                    while(true) {


                                        //it'll print out the all items on the ground - k
                                        characters.get(characterIndex).listInventory();

                                        // I choose the item from the table

                                        try {
                                            System.out.println("Please pick the item ");
                                            particularItemTableIndex = scanner.nextInt();
                                            System.out.println();
                                            break;
                                        } catch (InputMismatchException e) {
                                            scanner.nextLine();
                                            System.out.println();
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("Please don't try to crash my program and enter integer :)");
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println();
                                            continue;
                                        }
                                    }


                                    int itemIndex = particularItemTableIndex - 1;

                                    if (characters.get(characterIndex).getInventory().get(itemIndex) instanceof Weapon) {

                                        characters.get(characterIndex).getInventory().add(characters.get(characterIndex).getWeaponHoldingOnHand());

                                        System.out.println();
                                        System.out.println("----------------------------");
                                        System.out.println(characters.get(characterIndex).getWeaponHoldingOnHand().getName() + "Added your inventory");
                                        System.out.println("----------------------------");
                                        characters.get(characterIndex).setWeaponHoldingOnHand((Weapon) characters.get(characterIndex).getInventory().get(itemIndex));
                                        System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " is wielded");
                                        characters.get(characterIndex).getInventory().remove(itemIndex);
                                        System.out.println("----------------------------");
                                        System.out.println();


                                    }

                                    else if (characters.get(characterIndex).getInventory().get(itemIndex) instanceof Armor) {

                                        characters.get(characterIndex).getInventory().add(characters.get(characterIndex).getArmorOnCharacter());

                                        System.out.println();
                                        System.out.println("----------------------------");
                                        System.out.println(characters.get(characterIndex).getArmorOnCharacter().getName() + "Added your inventory");
                                        System.out.println("----------------------------");
                                        characters.get(characterIndex).setArmorOnCharacter((Armor) characters.get(characterIndex).getInventory().get(itemIndex));
                                        System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " is wearing...");
                                        characters.get(characterIndex).getInventory().remove(itemIndex);
                                        System.out.println("----------------------------");
                                        System.out.println();


                                    }





                                }

                                else {
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    System.out.println("There is no item in your inventory");
                                    System.out.println("--------------------------------------");
                                    System.out.println();
                                    continue;
                                }
                            }
                            else if (input == 5) {

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
                            else if (input == 6) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {


                                    int particularItemTableIndex = 0;

                                    while(true) {


                                        //it'll print out the all items on the ground - k
                                        characters.get(characterIndex).listInventory();

                                        // I choose the item from the table

                                        try {
                                            System.out.println("Please pick the item ");
                                            particularItemTableIndex = scanner.nextInt();
                                            System.out.println();
                                            break;
                                        } catch (InputMismatchException e) {
                                            scanner.nextLine();
                                            System.out.println();
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("Please don't try to crash my program and enter integer :)");
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println();
                                            continue;
                                        }
                                    }


                                    int itemIndex = particularItemTableIndex - 1;

                                    System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " removed from your inventory....");
                                    characters.get(characterIndex).removeItemFromInventory(characters.get(characterIndex).getInventory().get(itemIndex));

                                } else {
                                    System.out.println();
                                    characters.get(characterIndex).listInventory();
                                    System.out.println();
                                    continue;
                                }

                            }
                            else if (input == 7) {
                                break;
                            }

                        }

                        return;
                    } else {

                        enemyTurn(enemies, characters, 0);
                    }

                    System.out.println();
                    break;

                }

                else if (process == 2) {


                    //if last alive character is tired, one turn will pass without any action.
                    for (Character character : characters) {

                        if (character.isItAlive()) {
                            currentActiveCharacters++;
                        }
                    }

                    if (currentActiveCharacters == 1 && characters.get(characterIndex).isCharacterTired() == true) {
                        System.out.println("One turn passed without any action because " + characters.get(characterIndex).getRace() + " was tired.");
                        characters.get(characterIndex).setCharacterTired(false);
                        break;
                    }


                    currentActiveCharacters = 0;

                    if (characters.get(characterIndex).isCharacterTired() == true) {
                        System.out.println(characters.get(characterIndex).getRace() + " cannot be used for one turn...");
                        break;
                    }

                    for (Character character : characters)
                        character.setCharacterTired(false);


                    if (isThereAnyEnemy(enemies) == false) {

                        Thread.sleep(2000);
                        System.out.println();
                        System.out.println("----------------------------------");
                        System.out.println("there is no enemy anymore");
                        System.out.println("----------------------------------");


                        String menu3 = "Choose the process: \n\n"
                                + "---Dropped Items---\n"
                                + "1. Pick and Examine\n"
                                + "2. Wield / wear \n"
                                + "3. Pick and Add Your Inventory\n\n"
                                + "---Inventory Items---\n"
                                + "4. Pick and Wield / Wear \n"
                                + "5. List Inventory\n"
                                + "6. Drop Item From Your Inventory \n\n"
                                + "---Next Level--- \n"
                                + "7. Next \n";


                        while (true) {

                            System.out.println();
                            System.out.println("*********************************");
                            System.out.println(menu3);
                            System.out.println("*********************************");
                            System.out.println();


                            int input = 0;

                            try {
                                System.out.println("Please choose the process:");
                                input = scanner.nextInt();
                                System.out.println();
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

                            boolean isThereAnyItem = false;

                            for (Item item : droppedItems) {

                                if (item != null) {
                                    isThereAnyItem = true;
                                }

                            }


                            if (input == 1) {

                                if (isThereAnyItem == false) {
                                    System.out.println();
                                    System.out.println("-------------------------");
                                    System.out.println("There is no item to take");
                                    System.out.println("-------------------------");
                                    System.out.println();
                                    continue;
                                }


                                int particularItemTableIndex = 0;

                                while(true) {


                                    //it'll print out the all items on the ground - k
                                    showAllDroppedItems(droppedItems);

                                    // I choose the item from the table

                                    try {
                                        System.out.println("Please choose the item ");
                                        particularItemTableIndex = scanner.nextInt();
                                        System.out.println();
                                        break;
                                    } catch (InputMismatchException e) {
                                        scanner.nextLine();
                                        System.out.println();
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println("Please don't try to crash my program and enter integer :)");
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println();
                                        continue;
                                    }
                                }

                                int itemIndex = particularItemTableIndex - 1;

                                droppedItems.get(itemIndex).printItemInfo();

                                if (droppedItems.get(itemIndex) instanceof Sword) {
                                    System.out.print(" Attack Damage: " + droppedItems.get(itemIndex).getValue() * characters.get(characterIndex).getStrength());
                                }
                                if (droppedItems.get(itemIndex) instanceof Wand){
                                    System.out.print(" Attack Damage: " + droppedItems.get(itemIndex).getValue() * characters.get(characterIndex).getIntelligence());
                                }
                                if(droppedItems.get(itemIndex) instanceof Shield) {
                                    System.out.print(" Attack Damage: " + droppedItems.get(itemIndex).getValue() * characters.get(characterIndex).getVitality());
                                }
                                if(droppedItems.get(itemIndex) instanceof Armor) {
                                    System.out.print(" Extra hp:  " + ((Armor) droppedItems.get(itemIndex)).getExtraHp());
                                }

                                System.out.println();
                            }
                            else if (input == 2) {

                                if (isThereAnyItem == false) {
                                    System.out.println();
                                    System.out.println("-------------------------");
                                    System.out.println("There is no item to take");
                                    System.out.println("-------------------------");
                                    System.out.println();
                                    continue;
                                }


                                int particularItemTableIndex = 0;

                                while(true) {


                                    //it'll print out the all items on the ground - k
                                    showAllDroppedItems(droppedItems);

                                    // I choose the item from the table

                                    try {
                                        System.out.println("Please choose the item ");
                                        particularItemTableIndex = scanner.nextInt();
                                        System.out.println();
                                        break;
                                    } catch (InputMismatchException e) {
                                        scanner.nextLine();
                                        System.out.println();
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println("Please don't try to crash my program and enter integer :)");
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println();
                                        continue;
                                    }
                                }

                                int itemIndex = particularItemTableIndex - 1;

                                if(droppedItems.get(itemIndex) instanceof Weapon) {
                                    // if there is a problem to add your holding item to your inventory due to weight
                                    // there is a bug when you choose twice the 3 option
                                    // this method 'll develop
                                    if (droppedItems.get(itemIndex).isItTaken == false) {
                                        System.out.println("item which you hold has been changed.");
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getWeaponHoldingOnHand());
                                        characters.get(characterIndex).setWeaponHoldingOnHand((Weapon) droppedItems.get(itemIndex));
                                        droppedItems.get(itemIndex).isItTaken = true;
                                    } else if (droppedItems.get(itemIndex).isItTaken == true && characters.get(characterIndex).getWeaponHoldingOnHand() != droppedItems.get(itemIndex)) {
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getWeaponHoldingOnHand());
                                        characters.get(characterIndex).removeItemFromInventory(droppedItems.get(itemIndex));

                                        characters.get(characterIndex).setWeaponHoldingOnHand((Weapon) droppedItems.get(itemIndex));

                                    }

                                    else {

                                        System.out.println("you already get this");
                                    }
                                }

                                if(droppedItems.get(itemIndex) instanceof Armor) {
                                    // if there is a problem to add your holding item to your inventory due to weight
                                    // there is a bug when you choose twice the 3 option
                                    // this method 'll develop
                                    if (droppedItems.get(itemIndex).isItTaken == false) {
                                        System.out.println("item which you wear has been changed.");
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getArmorOnCharacter());
                                        characters.get(characterIndex).setArmorOnCharacter((Armor) droppedItems.get(itemIndex));
                                        droppedItems.get(itemIndex).isItTaken = true;
                                    } else if (droppedItems.get(itemIndex).isItTaken == true && characters.get(characterIndex).getWeaponHoldingOnHand() != droppedItems.get(itemIndex)) {
                                        characters.get(characterIndex).addItemToInventory(characters.get(characterIndex).getArmorOnCharacter());
                                        characters.get(characterIndex).removeItemFromInventory(droppedItems.get(itemIndex));

                                        characters.get(characterIndex).setArmorOnCharacter((Armor) droppedItems.get(itemIndex));

                                    }

                                    else {

                                        System.out.println("you already get this");
                                    }
                                }

                            }
                            else if (input == 3) {

                                if (isThereAnyItem == false) {
                                    System.out.println();
                                    System.out.println("-------------------------");
                                    System.out.println("There is no item to take");
                                    System.out.println("-------------------------");
                                    System.out.println();
                                    continue;
                                }


                                int particularItemTableIndex = 0;

                                while(true) {


                                    //it'll print out the all items on the ground - k
                                    showAllDroppedItems(droppedItems);

                                    // I choose the item from the table

                                    try {
                                        System.out.println("Please choose the item ");
                                        particularItemTableIndex = scanner.nextInt();
                                        System.out.println();
                                        break;
                                    } catch (InputMismatchException e) {
                                        scanner.nextLine();
                                        System.out.println();
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println("Please don't try to crash my program and enter integer :)");
                                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.println();
                                        continue;
                                    }
                                }

                                int itemIndex = particularItemTableIndex - 1;

                                if (droppedItems.get(itemIndex).isItTaken == false) {

                                    characters.get(characterIndex).addItemToInventory(droppedItems.get(itemIndex));
                                    droppedItems.get(itemIndex).isItTaken = true;
                                }
                                else {

                                    System.out.println("you already got this item");
                                }

                            }
                            else if (input == 4) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {

                                    int particularItemTableIndex = 0;

                                    while(true) {


                                        //it'll print out the all items on the ground - k
                                        characters.get(characterIndex).listInventory();

                                        // I choose the item from the table

                                        try {
                                            System.out.println("Please pick the item ");
                                            particularItemTableIndex = scanner.nextInt();
                                            System.out.println();
                                            break;
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
                                    }


                                    int itemIndex = particularItemTableIndex - 1;

                                    if (characters.get(characterIndex).getInventory().get(itemIndex) instanceof Weapon) {

                                        characters.get(characterIndex).getInventory().add(characters.get(characterIndex).getWeaponHoldingOnHand());

                                        System.out.println();
                                        System.out.println("----------------------------");
                                        System.out.println(characters.get(characterIndex).getWeaponHoldingOnHand().getName() + "Added your inventory");
                                        System.out.println("----------------------------");
                                        characters.get(characterIndex).setWeaponHoldingOnHand((Weapon) characters.get(characterIndex).getInventory().get(itemIndex));
                                        System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " is wielded");
                                        characters.get(characterIndex).getInventory().remove(itemIndex);
                                        System.out.println("----------------------------");
                                        System.out.println();


                                    }

                                    else if (characters.get(characterIndex).getInventory().get(itemIndex) instanceof Armor) {

                                        characters.get(characterIndex).getInventory().add(characters.get(characterIndex).getArmorOnCharacter());

                                        System.out.println();
                                        System.out.println("----------------------------");
                                        System.out.println(characters.get(characterIndex).getArmorOnCharacter().getName() + "Added your inventory");
                                        System.out.println("----------------------------");
                                        characters.get(characterIndex).setArmorOnCharacter((Armor) characters.get(characterIndex).getInventory().get(itemIndex));
                                        System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " is wearing...");
                                        characters.get(characterIndex).getInventory().remove(itemIndex);
                                        System.out.println("----------------------------");
                                        System.out.println();


                                    }



                                }

                                else {
                                    System.out.println();
                                    System.out.println("--------------------------------------");
                                    System.out.println("There is no item in your inventory");
                                    System.out.println("--------------------------------------");
                                    System.out.println();
                                    continue;
                                }
                            }
                            else if (input == 5) {

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
                            else if (input == 6) {

                                if (characters.get(characterIndex).getInventory().size() != 0) {



                                    int particularItemTableIndex = 0;

                                    while(true) {


                                        //it'll print out the all items on the ground - k
                                        characters.get(characterIndex).listInventory();

                                        // I choose the item from the table

                                        try {
                                            System.out.println("Please pick the item ");
                                            particularItemTableIndex = scanner.nextInt();
                                            System.out.println();
                                            break;
                                        } catch (InputMismatchException e) {
                                            scanner.nextLine();
                                            System.out.println();
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("Please don't try to crash my program and enter integer :)");
                                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println();
                                            continue;
                                        }
                                    }











                                    int itemIndex = particularItemTableIndex - 1;

                                    System.out.println(characters.get(characterIndex).getInventory().get(itemIndex).getName() + " removed from your inventory....");
                                    characters.get(characterIndex).removeItemFromInventory(characters.get(characterIndex).getInventory().get(itemIndex));

                                } else {
                                    System.out.println();
                                    characters.get(characterIndex).listInventory();
                                    System.out.println();
                                    continue;
                                }

                            }
                            else if (input == 7) {
                                break;
                            }

                        }

                        return;
                    } else {

                        characters.get(characterIndex).getWeaponHoldingOnHand().SpecialAction(characters, enemies, characters.get(characterIndex));

                    }

                    break;
                }

                else if (process == 3) {

                    characters.get(characterIndex).listInventory();
                }

                else if (process == 4) {

                    if (characters.get(characterIndex).getInventory().size() == 0) {
                        System.out.println("-----------------------------------------");
                        System.out.println("There is no item in your inventory yet");
                        System.out.println("-----------------------------------------");
                    } else {
                        characters.get(characterIndex).wieldOrWear();
                    }

                }



                else if (process == 5) {

                    if (characters.get(characterIndex).getInventory().size() != 0) {

                        int particularItemTableIndex = 0;

                        while(true) {


                            //it'll print out the all items on the ground - k
                            characters.get(characterIndex).listInventory();

                            // I choose the item from the table

                            try {
                                System.out.println("Please pick the item ");
                                particularItemTableIndex = scanner.nextInt();
                                System.out.println();
                                break;
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println();
                                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                System.out.println("Please don't try to crash my program and enter integer :)");
                                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                System.out.println();
                                continue;
                            }
                        }


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

                else {
                    System.out.println();
                    System.out.println("*******************");
                    System.out.println("You entered invalid value....");
                    System.out.println("*******************");
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("You have to choose it again....");
                    System.out.println("-------------------------");
                    continue;
                }
            }
        }

        System.out.println();
        System.out.println("Please, Enter your name to save your score: ");

        scanner.nextLine();

        String userName = null;
        String[] names = null;

        while (true) {
            userName = scanner.nextLine();

            names = userName.split(" ");

            if (names.length >= 3) {
                System.out.println();
                System.out.println("Your name cannot be longer then two sentences.");
                System.out.println();
                continue;
            }
            else
                break;
        }

        String saveTheName = "Name of the user: " + names[0] + "\n";

        if (names.length == 2)
            saveTheName += "Last name of the user: " + names[1].toUpperCase() + "\n";

        saveTheName += "Score: " + Main.point + "\n";
        saveTheName += "-------------------" + "\n";


        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("file.txt",true);


            byte[] s_array = saveTheName.getBytes();


            fos.write(s_array);


        }

        catch (FileNotFoundException ex) {
            System.out.println("File Not found exception....");
        }

        catch (IOException ex) {
            System.out.println("an error occured while the file is being writed...");
        }

        finally{

            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("an error occured while your file is being closed...");
            }

        }




        System.out.println("************************************");
        System.out.println("Game is over your score is : " + point);
        System.out.println("************************************");
        point = 0;
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

                int characterDecision = 0;
                try {
                    characterDecision = scanner.nextInt();

                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println();
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Please don't try to crash my program and enter integer :)");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println();
                    continue;
                }

                int characterIndex = characterDecision - 1;

                if (!characters.get(characterIndex).isItAlive()) {
                    System.out.println("You cannot choose that character because he is already dead...");
                    continue;
                }

                else {
                    System.out.println();
                    return characterIndex;
                }







        }
    }









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
        /*
        System.out.println();


        System.out.println("Creating Level " + currentLevel + ", with " + (int) Math.pow(2.0, currentLevel) + " enemy soldier.");
        System.out.println("Entering Level " + currentLevel + " Fighter enters.");
        System.out.println();


 */
        Thread.sleep(1500);


        while (isThereAnyCharacter(characters)) {

            //we need to check if  the character is alive here.unless it will continue to hit even though it is dead.
            String isFighterAlive = characters.get(0).isItAlive() ? "Alive" : "Dead";
            String isHealerAlive = characters.get(1).isItAlive() ? "Alive" : "Dead";
            String isTankAlive = characters.get(2).isItAlive() ? "Alive" : "Dead";


            String willFighterEnter = " Fighter is dead";
            if (isFighterAlive=="Alive"){
                willFighterEnter = ", Fighter enters,";
            }

            String willHealerEnter = " Healer is dead";
            if (isHealerAlive=="Alive"){
                willHealerEnter = " Healer enters";
            }

            String willTankEnter = " Tank is dead,";
            if (isTankAlive=="Alive"){
                willTankEnter = " Tank enters,";

            }


            System.out.println();
            System.out.println("Next level is starting");
            System.out.println();
            System.out.println("Creating Level " + currentLevel + ", with " + (int) Math.pow(2.0, currentLevel) + " enemy soldier.");
            System.out.println("Entering Level " + currentLevel + willFighterEnter + willTankEnter + willHealerEnter);
            System.out.println();

            gameTable(characters, createEnemy(currentLevel));
            currentLevel++;






        }
    }
}