public class Shield extends Item {
    public Shield(String name, int weight, double value) {
        super(name, weight, value);
    }

    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getVitality(); //shield damage will be calculated based on vitality
        return attackDamage;
    }

    public void attack(Character chosenEnemy, Character chosenCharacter) {

        System.out.println(chosenCharacter.getRace() + " are attacking....");
        System.out.println(chosenCharacter.getRace() + " gave " + calculateAttackDamage(chosenCharacter) + " damage to the " + chosenEnemy.getRace());

        if (chosenEnemy.getHp() - (long) calculateAttackDamage(chosenCharacter) <= 0) {

            chosenEnemy.setHp(0);
            chosenEnemy.setItAlive(false);
            System.out.println(chosenEnemy.getRace() + " is dead");
        } else {
            chosenEnemy.setHp(chosenEnemy.getHp() - (long) calculateAttackDamage(chosenCharacter));
        }

    }
}