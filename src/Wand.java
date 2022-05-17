public class Wand extends Item {

    public Wand(String name, int weight, double value) {
        super(name, weight, value);
    }


    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getIntelligence();// wand damage will calculate based on intelligence
        return attackDamage;
    }

    public void attack(Character chosenEnemy, Character chosenCharacter) {
        System.out.println("You are attacking....");
        System.out.println("you gave " + calculateAttackDamage(chosenCharacter) + "to the enemy");

        if (chosenEnemy.getHp() - (long) calculateAttackDamage(chosenCharacter) < 0) {
            chosenEnemy.setHp(chosenEnemy.getHp() - (long) calculateAttackDamage(chosenCharacter));
            System.out.println("Warrior is dead");
            //   chosenEnemy.setDoesItLive(false);
        } else
            chosenEnemy.setHp(chosenEnemy.getHp() - (long) calculateAttackDamage(chosenCharacter));
        //   if (chosenEnemy.isDoesItLive())
        //  System.out.println("new hp for the enemy is: " + chosenEnemy.getHp());


    }


}