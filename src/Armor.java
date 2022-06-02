public class Armor extends Cloth{

    private double extraHp;

    public Armor(String name, int weight, double value) {
        super(name, weight, value);
        this.extraHp = calculateDefence();
    }

    public double calculateDefence(){
        double defence = getValue() * 3;
        return defence;
    }

    public double getExtraHp() {
        return extraHp;
    }

    public void setExtraHp(double extraHp) {
        this.extraHp = extraHp;
    }
}
