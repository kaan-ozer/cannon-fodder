public class Sword extends Item {

    private int defaultSwordDamageValue;

    public Sword(String name, int weight,
             double value,int defaultSwordDamageValue) {
        super(name,weight,value);
        this.defaultSwordDamageValue = defaultSwordDamageValue;
    }

    public int getDefaultSwordDamageValue() {
        return defaultSwordDamageValue;
    }

    public void setDefaultSwordDamageValue(int defaultSwordDamageValue) {
        this.defaultSwordDamageValue = defaultSwordDamageValue;
    }
}
