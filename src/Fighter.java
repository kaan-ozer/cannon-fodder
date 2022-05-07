public class Fighter extends Character{

    //constructor for fighter, fighter is a character, and we used the character's constructor via super.
    public Fighter(int strength,int vitality, int intelligence) {
        super(strength,vitality,intelligence);
    }

    //default constructor
    public Fighter() {
        super(0,0,0);
    }
}
