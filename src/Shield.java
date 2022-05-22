
public  class Shield extends Item{

    public Shield(String name,int weight,double value){

        super(name, weight, value);
    }

    public double calculateDefence(Character character){
      double defence=getValue() * character.getVitality();
      return defence;
    }

    public void defence(Character chosenEnemy,Character chosenCharacter){
        System.out.println( chosenCharacter.getRace() + " is defencing....");
        System.out.println( chosenCharacter.getRace() + " defenced " + calculateDefence(chosenCharacter) + " damages from the " + chosenEnemy.getRace());



    }

    public double calculateAttackDamage(Character character) {

        double attackDamage = getValue() * character.getVitality(); //shield damage will be calculated based on vitality
        return attackDamage;
    }

    @Override
    public void SpecialAction(boolean isSpecialActionWithShield ,Character chosenEnemy, Character chosenCharacter,Character C) {
        System.out.println("special action activated !"+chosenCharacter.getRace()+"to  stun"+chosenEnemy.getRace());
        System.out.println(chosenEnemy.getRace()+"stunned");
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