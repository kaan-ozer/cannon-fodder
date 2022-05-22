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
        charactersAreAtBeginning.add(tank);
        charactersAreAtBeginning.add(healer);


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
    public static Item dropItem() {

        int number = randomNumber.nextInt(101);

        if (number <= 24) {
            Sword longSword = new Sword("longSword",2,2);
            return longSword;
        }

        else if(number >= 25 && number <= 39) {
            Sword brokenSword = new Sword("brokenSword",1,1.2);
            return brokenSword;
        }

        else if( number >= 40  && number <= 45 ) {
            Sword excalibur = new Sword("excalibur",1,2.5);
            return excalibur;
        }

        else if(number < 70 && number > 45){
            Wand woodenWand=new Wand("woodenWand",1,1.5);
                return woodenWand;
        }
        else if(number < 90 && number >= 70){

            Wand boneWand=new Wand("boneWand", 2,2.3);
            return boneWand;
        }
        else if(number<65&& number < 80){
            Wand steelWand=new Wand("steelWand", 2,2.6);
            return steelWand;
        }
        else if(number<80 && number < 90){
          Shield  bucklerShieled=new Shield("bucklerShiled",1,2);
          return bucklerShieled;
        }
        else if(number<90 && number < 101){
            Shield smallShield=new Shield("smallShield", 2,1.5);
            return smallShield;
        }
        else {
            return null;
        }




    }
    //

    public static boolean wantUseSpecialAction(int userInput) {
        boolean haveSpecialAction = false;

        if (userInput== 1) {
            haveSpecialAction=true;


        }

        else if (userInput==0){
            haveSpecialAction=false;

        }
        return haveSpecialAction;
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

        boolean isThereAnyEnemy = false;   //name better to be isThereAnyCharacter

        for(int i = 0; i < characters.size() ; i++) {

            if (characters.get(i).isItAlive() == true) {

                isThereAnyEnemy = true;

            }
        }

        return isThereAnyEnemy;

    }
    public static void gameTable(ArrayList<Character> characters,ArrayList<Enemy> enemies,int characterIndex) {



        while (isThereAnyCharacter(characters)) {

            if(characters.get(characterIndex).isItAlive()) {
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
//we need try catch here to catch the boundOfexception


                System.out.println("----------------------------------");

                boolean isActionWithWand=false;
                boolean isActionWithShield=false;
                boolean isActionWithSword=false;

                System.out.println("for special action press 1 for normal action press 0: ");
                int playerDecision=scanner.nextInt();
                switch (playerDecision){
                    case 0:
                        characters.get(characterIndex).getItemHoldingOnHand().attack(enemies.get(index), characters.get(characterIndex));//is this break necessary?
                        break;

                    case 1:if (characters.get(characterIndex).getItemHoldingOnHand().getClass().getName().equals("Wand")){
                        isActionWithWand=true;
                        System.out.println("enter: 1-to heal fighter ,  2-to heal tank ,   3-to heal healer  ");
                        int healChoice=scanner.nextInt();
                        if (healChoice==1){//heal the fighter
                            characters.get(characterIndex).getItemHoldingOnHand().SpecialAction(isActionWithWand,enemies.get(particularEnemyTableIndex),characters.get(characterIndex),characters.get(characterIndex-2));
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

                }



                System.out.println("----------------------------------");






                if (isThereAnyEnemy(enemies) == false) {



                    System.out.println();
                    System.out.println("----------------------------------");
                    System.out.println("there is no enemy anymore");
                    System.out.println("----------------------------------");

                    Item droppedItem = dropItem();

                    System.out.println();
                    System.out.println("*********************************");
                    System.out.println(droppedItem.getName() + " has dropped");
                    System.out.println("*********************************");
                    System.out.println();

                    String menu2 = "Choose the process: \n"
                            + "1. Add this item to the inventory\n"
                            + "2. list inventory\n"
                            + "3. wield this item\n"
                            + "4. to quit\n"
                            + "5.test this item\n";  //there should be- test this item -option to show the item info before we decide to pick it up . better to change menu order

                    boolean didYouAddBefore = false;

                    while (true) {
                        System.out.println();
                        System.out.println("*********************************");
                        System.out.println(menu2);
                        System.out.println("*********************************");
                        System.out.println();

                        int input = scanner.nextInt();

                        if (input == 1) {
                            if (didYouAddBefore == false) {

                                characters.get(characterIndex).addItemToInventory(characters.get(characterIndex), droppedItem);
                                didYouAddBefore = true;
                            }
                            else {

                                System.out.println("you already got this item");
                            }

                        }
                        else if(input == 2) {

                            characters.get(characterIndex).listInventory();
                        }
                        else if(input == 3) {
                            // if there is a problem to add your holding item to your inventory due to weight
                            // there is a bug when you choose twice the 3 option
                            // this method 'll develop
                            if (didYouAddBefore == false) {
                                System.out.println("item which you hold has been changed.");
                                characters.get(characterIndex).addItemToInventory(characters.get(characterIndex), characters.get(characterIndex).getItemHoldingOnHand());
                                characters.get(characterIndex).setItemHoldingOnHand(droppedItem);
                                didYouAddBefore = true;
                            }
                            else if(didYouAddBefore == true && characters.get(characterIndex).getItemHoldingOnHand() != droppedItem ) {
                                characters.get(characterIndex).addItemToInventory(characters.get(characterIndex), characters.get(characterIndex).getItemHoldingOnHand());
                                characters.get(characterIndex).removeItemFromInventory(characters.get(characterIndex),droppedItem);

                                characters.get(characterIndex).setItemHoldingOnHand(droppedItem);

                            }
                            else {

                                System.out.println("you already get this");
                            }
                        }
                        else if (input == 4) {
                            break;
                        }
                        else if (input==5){
                            if (didYouAddBefore == true||!didYouAddBefore) {
                               droppedItem.printItemInfo();
                            }
                        }
                    }



                    return;

                }

                else {
                    System.out.println();
                    System.out.println("----------------------------------");
                    System.out.println("Enemies turn....");
                    System.out.println("----------------------------------");
                    System.out.println();

                    boolean passTheTurn = false;   //if the special action is for" sword "one turn of enemy and character  should be passed
                    if (isActionWithSword){passTheTurn=true;
                     }

                    for (int i = 0; i < enemies.size(); i++) {

                        if (enemies.get(i).isItAlive()) {

                            for (int j = 0; j < characters.size(); j++) {

                                if (characters.get(j).isItAlive()) {
                                    System.out.println("----------------------------------");
                                    enemies.get(i).getItemHoldingOnHand().attack(characters.get(j), enemies.get(j));
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
            else {
                characterIndex = characterMenu(characters);
            }

        }


    }
    public static int characterMenu(ArrayList<Character> characters) {

        while(true) {
            System.out.println();
            String isFighterAlive = characters.get(0).isItAlive() ? "Alive" : "Dead";
            String isTankAlive = characters.get(1).isItAlive() ? "Alive" : "Dead";
            String isHealerAlive = characters.get(2).isItAlive() ? "Alive" : "Dead";

            String actionMenu = "Choose your character: \n"
                    + "1.Fighter (" + isFighterAlive + ")\n"
                    + "2.Tank (" + isTankAlive + ")\n"
                    + "3.Healer (" + isHealerAlive + ")";

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


           while(isThereAnyCharacter(characters)) {


               int characterIndex = characterMenu(characters);

               //we need to check if  the charcter is alive here.unless it will continue to hit even though it is dead.


               gameTable(characters, createEnemy(currentLevel), characterIndex);
               currentLevel++;

               if (isThereAnyCharacter(characters)) {
                   System.out.println();
                   System.out.println("Next level is starting");
                   System.out.println();

               }

           }















    }

}
