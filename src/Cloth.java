public abstract class Cloth extends Item{

    public Cloth(String name,int weight,double value){
        super(name,weight,value);
    }

    public double calculateDefence(Character character){
        double defence=getValue() * character.getVitality();
        return defence;
    }

    public void defence(Character chosenEnemy,Character chosenCharacter) {
        System.out.println(chosenCharacter.getRace() + " is defencing....");
        System.out.println(chosenCharacter.getRace() + " defenced " + calculateDefence(chosenCharacter) + " damages from the " + chosenEnemy.getRace());

    }
}
