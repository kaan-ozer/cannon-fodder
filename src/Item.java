public abstract class Item {
    String name;
    int weight;
    double value;

    //constructor
    public Item(String name, int weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    //kaan'll develop that part
    public abstract void attack(Character chosenEnemy, Character chosenCharacter);
    public abstract  void SpecialAction(boolean specialAction,Character chosenEnemy, Character chosenCharacter,Character characterTo);
    //each weapon has a Special action(page 2 of project instruction)
    public void printItemInfo(){
        System.out.println("name: "+getName()+"  weight: "+getWeight()+"   value: "+getValue());



    }


    //getter-setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }



}
