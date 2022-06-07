public class Item {

    String name;
    int weight;
    double value;
    boolean isItTaken;

    //constructor
    public Item(String name, int weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.isItTaken = false;
    }



    //each weapon has a Special action(page 2 of project instruction)
    public void printItemInfo(){

        System.out.print("name: "+getName()+"  weight: "+getWeight()+" value: "+getValue());



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
