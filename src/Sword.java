public class Sword extends Item {
    private int totalDamage;

    public Sword(String name, int weight,
             double value,int swordDamage,Character character) {
        super(name,weight,value);
        this.totalDamage = swordDamage * character.getStrength();
    }
}
