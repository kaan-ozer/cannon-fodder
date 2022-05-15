import java.util.ArrayList;

public interface Actions {

    // we need those methods, don't worry about them it is just a reminder for now
    public void wield(Item item);
    public void wear(Item item);
    public void attack(ArrayList<Enemy> enemies, ArrayList<Character> characters);
    public void pick();
    public void examine();
    public void listİnventory();
    public void specialAttack();
}
