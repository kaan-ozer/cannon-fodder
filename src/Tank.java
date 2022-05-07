public class Tank extends Character {

    //constructor for tank, tank is a character, and we used the character's constructor via super.
    public Tank(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);
    }

    //default constructor
    public Tank() {
        super(0,0,0);
    }
}
