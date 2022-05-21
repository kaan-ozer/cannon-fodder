
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
    public void SpecialAction(Item chosenItem, Character chosenEnemy, Character chosenCharacter) {
        System.out.println("special action activated !"+chosenCharacter.getRace()+"is using "+chosenItem.name+"to  stun"+chosenEnemy.getRace());
        System.out.println(chosenEnemy.getRace()+"stunned");//later maybe in main we have to keep enemy away from attacking at least for one turn or for simulating this situation we can attack  by character two times in a row
        //later maybe in main we have to keep enemy away from attacking at least for one turn or for simulating this situation we can attack  by character two times in a row
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