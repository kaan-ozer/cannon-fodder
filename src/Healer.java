public class Healer extends Character{

    //constructor for healer, healer is a character, and we used the character's constructor via super.
    public Healer(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);
    }

    //default constructor
    public Healer() {
        super(0,0,0);
    }
}
